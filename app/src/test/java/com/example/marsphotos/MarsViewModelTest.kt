package com.example.marsphotos

import com.example.marsphotos.data.MarsPhotosRepository
import com.example.marsphotos.fake.FakeNetworkMarsPhotosRepository
import com.example.marsphotos.fake.FakeDataSource
import com.example.marsphotos.rules.TestDispatcherRule
import com.example.marsphotos.ui.screens.MarsUiState
import com.example.marsphotos.ui.screens.MarsViewModel
import java.io.IOException
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response

class MarsViewModelTest {
    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    @Test
    fun getMarsPhotos_successUsesInjectedRepository() = runTest {
        val viewModel = MarsViewModel(FakeNetworkMarsPhotosRepository())
        assertEquals(MarsUiState.Success(FakeDataSource.photosList), viewModel.marsUiState)
    }

    @Test
    fun getMarsPhotos_remainsLoadingUntilResponse() = runTest {
        val response = CompletableDeferred<List<com.example.marsphotos.model.MarsPhoto>>()
        val viewModel = MarsViewModel(object : MarsPhotosRepository {
            override suspend fun getMarsPhotos() = response.await()
        })
        assertEquals(MarsUiState.Loading, viewModel.marsUiState)
        response.complete(FakeDataSource.photosList)
        assertEquals(MarsUiState.Success(FakeDataSource.photosList), viewModel.marsUiState)
    }

    @Test
    fun getMarsPhotos_ioExceptionShowsError() = runTest {
        val viewModel = MarsViewModel(object : MarsPhotosRepository {
            override suspend fun getMarsPhotos() = throw IOException("Offline")
        })
        assertEquals(MarsUiState.Error, viewModel.marsUiState)
    }

    @Test
    fun getMarsPhotos_httpExceptionShowsError() = runTest {
        val viewModel = MarsViewModel(object : MarsPhotosRepository {
            override suspend fun getMarsPhotos() = throw HttpException(
                Response.error<Any>(503, "Unavailable".toResponseBody())
            )
        })
        assertEquals(MarsUiState.Error, viewModel.marsUiState)
    }

    @Test
    fun getMarsPhotos_retryRecoversAfterFailure() = runTest {
        var offline = true
        val viewModel = MarsViewModel(object : MarsPhotosRepository {
            override suspend fun getMarsPhotos() = if (offline) {
                throw IOException("Offline")
            } else FakeDataSource.photosList
        })
        assertEquals(MarsUiState.Error, viewModel.marsUiState)
        offline = false
        viewModel.getMarsPhotos()
        assertEquals(MarsUiState.Success(FakeDataSource.photosList), viewModel.marsUiState)
    }
}

package com.example.marsphotos

import com.example.marsphotos.data.NetworkMarsPhotosRepository
import com.example.marsphotos.fake.FakeDataSource
import com.example.marsphotos.fake.FakeMarsApiService
import com.example.marsphotos.network.MarsApiService
import java.io.IOException
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

class NetworkMarsRepositoryTest {
    @Test
    fun getMarsPhotos_returnsServicePhotos() = runTest {
        val repository = NetworkMarsPhotosRepository(FakeMarsApiService())
        assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
    }

    @Test
    fun getMarsPhotos_propagatesNetworkFailure() = runTest {
        val repository = NetworkMarsPhotosRepository(object : MarsApiService {
            override suspend fun getPhotos() = throw IOException("Offline")
        })
        try {
            repository.getMarsPhotos()
            fail("Expected IOException")
        } catch (exception: IOException) {
            assertEquals("Offline", exception.message)
        }
    }
}

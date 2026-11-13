package com.example.marsphotos.fake

import com.example.marsphotos.model.MarsPhoto

object FakeDataSource {
    val photosList = listOf(
        MarsPhoto("img1", "https://example.com/mars1.jpg"),
        MarsPhoto("img2", "https://example.com/mars2.jpg")
    )
}

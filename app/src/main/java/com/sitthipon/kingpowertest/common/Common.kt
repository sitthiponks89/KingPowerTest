package com.sitthipon.kingpowertest.common

import com.sitthipon.kingpowertest.retrofit.RetrofitClient
import com.sitthipon.kingpowertest.service.PhotosService

object Common {
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val retrofitService: PhotosService
        get() = RetrofitClient.getClient(BASE_URL).create(PhotosService::class.java)
}
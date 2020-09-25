package com.sitthipon.kingpowertest.service

import com.sitthipon.kingpowertest.model.Photos
import retrofit2.Call
import retrofit2.http.GET

interface PhotosService {
    @GET("albums/1/photos")
    fun getPhotos(): Call<MutableList<Photos>>
}
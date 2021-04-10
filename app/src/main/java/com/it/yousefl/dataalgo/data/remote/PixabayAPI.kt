package com.it.yousefl.dataalgo.data.remote

import com.it.yousefl.dataalgo.BuildConfig
import com.it.yousefl.dataalgo.data.remote.responses.ImageResponse
import com.it.yousefl.dataalgo.data.remote.responses.ImageResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayAPI {

    @GET("/api/")
    suspend fun searchForImage(@Query("q") searchQuery:String,
                               @Query("key")apiKey:String=BuildConfig.Api_Key):Response<ImageResponse>

}
package com.mohamed.articaledemoapp.ui.main.data.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("viewed/7.json")
    fun getAllArticles(@Query("api-key") apiKey : String)
}
package com.mohamed.articaledemoapp.ui.main.di

import android.content.Context
import android.net.ConnectivityManager
import com.mohamed.articaledemoapp.ui.main.data.retrofit.ApiInterface
import com.mohamed.articaledemoapp.ui.main.utilities.Constants
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single {
        Retrofit.Builder().baseUrl(Constants.api.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(ApiInterface::class.java)
    }

    single {
        get<Context>().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}
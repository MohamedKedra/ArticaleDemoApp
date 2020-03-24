package com.mohamed.articaledemoapp.ui.main.ui.main.data

import com.mohamed.articaledemoapp.ui.main.data.model.PopularArticlesResponse
import com.mohamed.articaledemoapp.ui.main.data.retrofit.ApiInterface
import com.mohamed.articaledemoapp.ui.main.ui.bases.BaseRepository
import com.mohamed.articaledemoapp.ui.main.utilities.Constants
import retrofit2.Call

class MainRepository(apiInterface: ApiInterface) : BaseRepository(apiInterface) {

    fun getAllArticles(): Call<PopularArticlesResponse> =
        apiInterface.getAllArticles(Constants.api.API_KEY)

}
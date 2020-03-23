package com.mohamed.articaledemoapp.ui.main.ui.main.data

import androidx.lifecycle.MutableLiveData
import com.mohamed.articaledemoapp.ui.main.data.model.PopularArticlesResponse
import com.mohamed.articaledemoapp.ui.main.data.model.Result
import com.mohamed.articaledemoapp.ui.main.data.retrofit.ApiInterface
import com.mohamed.articaledemoapp.ui.main.ui.bases.BaseRepository
import com.mohamed.articaledemoapp.ui.main.utilities.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(apiInterface: ApiInterface) : BaseRepository(apiInterface) {

    fun getAllArticles(): MutableLiveData<List<Result>> {

        val results = MutableLiveData<List<Result>>()

        apiInterface.getAllArticles(Constants.api.API_KEY).enqueue(object :
            Callback<PopularArticlesResponse> {

            override fun onResponse(
                call: Call<PopularArticlesResponse>,
                response: Response<PopularArticlesResponse>
            ) {
                if(response.isSuccessful) {
                    results.value = response.body()?.results
                }else{
                    results.value = null
                }
            }

            override fun onFailure(call: Call<PopularArticlesResponse>, t: Throwable) {

                results.value = null
            }
        })
        return results
    }
}
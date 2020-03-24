package com.mohamed.articaledemoapp.ui.main.ui.main.viewModel

import android.net.ConnectivityManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mohamed.articaledemoapp.ui.main.data.model.PopularArticlesResponse
import com.mohamed.articaledemoapp.ui.main.data.model.Result
import com.mohamed.articaledemoapp.ui.main.ui.bases.BaseViewModel
import com.mohamed.articaledemoapp.ui.main.ui.bases.StateLiveData
import com.mohamed.articaledemoapp.ui.main.ui.main.data.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(
    private val mainRepository: MainRepository,
    connectivityManager: ConnectivityManager
) : BaseViewModel(connectivityManager) {

    private val articlesLiveData: StateLiveData<List<Result>> = StateLiveData()
    private val allArticlesLiveData: StateLiveData<PopularArticlesResponse> = StateLiveData()

    fun getAllArticles() : StateLiveData<PopularArticlesResponse>{

        if(!isNetworkAvailable){
            publishNoInternet(allArticlesLiveData)
            return allArticlesLiveData
        }

        performApiCall(allArticlesLiveData,mainRepository.getAllArticles())

        publishLoading(allArticlesLiveData)

        return allArticlesLiveData
    }

    fun getArticles() :  StateLiveData<List<Result>>{

        articlesLiveData.postLoading()

        mainRepository.getAllArticles().enqueue(object :
            Callback<PopularArticlesResponse> {
            override fun onFailure(call: Call<PopularArticlesResponse>, t: Throwable) {
                articlesLiveData.postError(t)
            }

            override fun onResponse(
                call: Call<PopularArticlesResponse>,
                response: Response<PopularArticlesResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.results?.let {
                        articlesLiveData.postSuccess(it)
                    }?: run{
                        articlesLiveData.postNotComplete()
                    }
                } else {
                    articlesLiveData.postNotComplete()
                }
            }
        })
        return articlesLiveData
    }
}

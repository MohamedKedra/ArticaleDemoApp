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
}

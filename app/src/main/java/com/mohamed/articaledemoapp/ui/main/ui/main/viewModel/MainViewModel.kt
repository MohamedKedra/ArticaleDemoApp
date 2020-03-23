package com.mohamed.articaledemoapp.ui.main.ui.main.viewModel

import android.net.ConnectivityManager
import androidx.lifecycle.LiveData
import com.mohamed.articaledemoapp.ui.main.data.model.Result
import com.mohamed.articaledemoapp.ui.main.ui.bases.BaseViewModel
import com.mohamed.articaledemoapp.ui.main.ui.main.data.MainRepository

class MainViewModel(
    private val mainRepository: MainRepository,
    connectivityManager: ConnectivityManager
) : BaseViewModel(connectivityManager) {

    fun getAllArticles(): LiveData<List<Result>> = mainRepository.getAllArticles()
}

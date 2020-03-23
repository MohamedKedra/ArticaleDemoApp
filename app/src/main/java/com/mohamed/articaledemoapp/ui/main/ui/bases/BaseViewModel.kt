package com.mohamed.articaledemoapp.ui.main.ui.bases

import android.net.ConnectivityManager
import androidx.lifecycle.ViewModel

abstract class BaseViewModel(protected val connectivityManager: ConnectivityManager) : ViewModel() {

}
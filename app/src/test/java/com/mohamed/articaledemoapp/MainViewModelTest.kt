package com.mohamed.articaledemoapp

import android.net.ConnectivityManager
import androidx.lifecycle.Observer
import com.mohamed.articaledemoapp.ui.main.data.model.PopularArticlesResponse
import com.mohamed.articaledemoapp.ui.main.ui.bases.StateData
import com.mohamed.articaledemoapp.ui.main.ui.bases.StateLiveData
import com.mohamed.articaledemoapp.ui.main.ui.main.data.MainRepository
import com.mohamed.articaledemoapp.ui.main.ui.main.viewModel.MainViewModel
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @Mock
    lateinit var mainRepository: MainRepository

    @Mock
    lateinit var connectivityManager: ConnectivityManager

    lateinit var mainViewModel : MainViewModel

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        mainViewModel = MainViewModel(mainRepository, connectivityManager)
    }

    @Test
    fun fetchDataFromApi(){

        Mockito.`when`(mainRepository.getAllArticles()).thenAnswer {
            return@thenAnswer ArgumentMatchers.anyList<MainRepository>()
        }

        val observer = mock(Observer::class.java) as Observer<StateData<PopularArticlesResponse>>

        mainViewModel.allArticlesLiveData.observeForever(observer)

        mainViewModel.getAllArticles()

        assertNotNull(this.mainViewModel.allArticlesLiveData.value)

        assertEquals(StateData.DataStatus.SUCCESS,mainViewModel.allArticlesLiveData.value?.getStatus())
    }

}
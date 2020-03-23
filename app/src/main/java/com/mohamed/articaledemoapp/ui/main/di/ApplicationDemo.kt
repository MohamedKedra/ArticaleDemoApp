package com.mohamed.articaledemoapp.ui.main.di

import android.app.Application
import com.mohamed.articaledemoapp.ui.main.ui.main.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationDemo : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ApplicationDemo)
            modules(
                listOf(
                    appModule,
                    mainModule
                )
            )
        }

    }

}
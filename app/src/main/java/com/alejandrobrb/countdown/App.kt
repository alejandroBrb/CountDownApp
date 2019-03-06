package com.alejandrobrb.countdown

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber


/**
 * @author Alejandro Barba on 3/6/19.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startLogger()
        initKoin()
    }

    private fun startLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initKoin() {
        startKoin {
            androidContext(androidContext = this@App)
        }
    }

}
package com.avility.apexcrypto

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class ApexCryptoApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // enabled timber only in debug mode
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}
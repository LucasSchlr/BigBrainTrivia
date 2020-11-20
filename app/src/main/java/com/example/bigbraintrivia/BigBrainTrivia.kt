package com.example.bigbraintrivia

import android.app.Application
import com.example.bigbraintrivia.di.androidModule
import org.koin.android.ext.android.startKoin
import org.koin.standalone.StandAloneContext

class BigBrainTrivia : Application(){

    var usuario = ""
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(androidModule))
    }

    override fun onTerminate() {
        super.onTerminate()
        StandAloneContext.stopKoin()
    }
}
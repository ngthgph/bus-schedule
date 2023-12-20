package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.AppContainer
import com.example.busschedule.data.AppDataContainer

class BusApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}

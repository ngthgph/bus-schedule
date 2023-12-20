package com.example.busschedule.data

import android.content.Context

interface AppContainer {
    val busRepository: BusRepository
}

class AppDataContainer(private val context: Context): AppContainer {
    override val busRepository: BusRepository by lazy {
        OfflineBusRepository(BusDatabase.getDatabase(context).busDao())
    }
}
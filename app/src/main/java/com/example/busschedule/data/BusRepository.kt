package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

interface BusRepository {
    fun getAllScheduleStream(): Flow<List<BusSchedule>>
    fun getScheduleStream(stopName: String): Flow<List<BusSchedule>>
}

class OfflineBusRepository(private val busDao: BusDao): BusRepository {
    override fun getAllScheduleStream(): Flow<List<BusSchedule>> = busDao.getAllSchedules()
    override fun getScheduleStream(stopName: String): Flow<List<BusSchedule>> = busDao.getSchedule(stopName)
}
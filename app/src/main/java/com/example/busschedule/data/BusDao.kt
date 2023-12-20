package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusDao {
    @Query("SELECT * FROM bus ORDER BY arrival_time")
    fun getAllSchedules(): Flow<List<BusSchedule>>

    @Query("SELECT * FROM bus WHERE stop_name = :stopName")
    fun getSchedule(stopName: String): Flow<BusSchedule>
}
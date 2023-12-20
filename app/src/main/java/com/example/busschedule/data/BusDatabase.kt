package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BusSchedule::class], version = 1, exportSchema = false)
abstract class BusDatabase: RoomDatabase() {
    abstract fun busDao(): BusDao

    companion object {
        @Volatile
        private var Instance: BusDatabase? = null

        fun getDatabase(context: Context): BusDatabase {
            return Instance?:synchronized(this) {
                Room.databaseBuilder(context, BusDatabase::class.java, "schedule_database")
                    .createFromAsset("database/bus_schedule.db")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
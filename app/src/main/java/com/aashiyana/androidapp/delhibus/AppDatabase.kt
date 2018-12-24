package com.aashiyana.androidapp.delhibus

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.aashiyana.androidapp.delhibus.dao.RoutesDao
import com.aashiyana.androidapp.delhibus.dao.StopTimesDao
import com.aashiyana.androidapp.delhibus.dao.StopsDao
import com.aashiyana.androidapp.delhibus.dao.TripsDao
import com.aashiyana.androidapp.delhibus.entity.Routes
import com.aashiyana.androidapp.delhibus.entity.StopTimes
import com.aashiyana.androidapp.delhibus.entity.Stops
import com.aashiyana.androidapp.delhibus.entity.Trips

@Database(entities = [Stops::class,Routes::class,Trips::class,StopTimes::class],version = 2,exportSchema = false)
abstract class AppDatabase():RoomDatabase() {
    abstract fun stopsDao():StopsDao
    abstract fun tripsDao():TripsDao
    abstract fun routesDao():RoutesDao
    abstract fun stopTimesDao():StopTimesDao
}
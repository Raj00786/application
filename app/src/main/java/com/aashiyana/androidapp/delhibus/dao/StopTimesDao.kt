package com.aashiyana.androidapp.delhibus.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.aashiyana.androidapp.delhibus.entity.StopTimes

@Dao
interface StopTimesDao {

    @Insert
    @JvmSuppressWildcards
    fun addAll(objects: List<StopTimes>)

    @Insert
    fun addStopTime(stopTimes: StopTimes)

    @Delete
    fun deleteStopTime(stopTimes: StopTimes)

    @Query("SELECT * FROM stop_times")
    fun getAllStopTimes():List<StopTimes>

    @Query("SELECT * FROM stop_times WHERE trip_id= :tripId")
    fun getStopTimesByTripId(tripId:Int): List<StopTimes>
}
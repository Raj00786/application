package com.aashiyana.androidapp.delhibus.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.aashiyana.androidapp.delhibus.entity.Stops

@Dao
interface StopsDao {

    @Insert
    @JvmSuppressWildcards
    fun addAll(objects: List<Stops>)

    @Insert
    fun addStop(stops:Stops)

    @Delete
    fun deleteStop(stops: Stops)

    @Query("SELECT * FROM stops")
    fun getAllStops():List<Stops>

    @Query("SELECT * FROM stops WHERE stop_id= :stopId")
    fun getStopByStopId(stopId:Int):Stops

}
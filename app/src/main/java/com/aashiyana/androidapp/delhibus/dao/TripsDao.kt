package com.aashiyana.androidapp.delhibus.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.aashiyana.androidapp.delhibus.entity.Stops
import com.aashiyana.androidapp.delhibus.entity.Trips

@Dao
interface TripsDao {

    @Insert
    @JvmSuppressWildcards
    fun addAll(objects: List<Trips>)

    @Insert
    fun addTrip(trips: Trips)

    @Delete
    fun deleteTrip(trips: Trips)

    @Query("SELECT * FROM trips")
    fun getAllTrips():List<Trips>

    @Query("SELECT * FROM trips WHERE trip_id= :tripId")
    fun getStopByTripId(tripId:Int): Trips
}
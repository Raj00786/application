package com.aashiyana.androidapp.delhibus.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.aashiyana.androidapp.delhibus.entity.Routes
import com.aashiyana.androidapp.delhibus.entity.Stops
import com.aashiyana.androidapp.delhibus.entity.Trips

@Dao
interface RoutesDao {

    @Insert
    @JvmSuppressWildcards
    fun addAll(objects: List<Routes>)

    @Insert
    fun addRoute(routes: Routes)

    @Delete
    fun deleteRoute(routes: Routes)

    @Query("SELECT * FROM routes")
    fun getAllRoutes():List<Routes>

    @Query("SELECT bus_code FROM routes")
    fun getAllBusCode():List<String>

    @Query("SELECT * FROM routes WHERE route_id= :routeId")
    fun getStopByRouteId(routeId:Int): Routes

    @Query("SELECT * FROM stops sp join stop_times st on st.stop_id = sp.stop_id WHERE st.trip_id= (SELECT trip_id from trips where route_id= (SELECT route_id from routes where bus_code= :busCode) limit 1)")
    fun getStopsList(busCode:String):List<Stops>
}
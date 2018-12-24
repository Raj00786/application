package com.aashiyana.androidapp.delhibus.entity

import android.arch.persistence.room.*
import org.jetbrains.annotations.NotNull

@Entity(tableName = "trips",indices = [Index(value = ["trip_id"], unique = true)],
        foreignKeys = arrayOf(ForeignKey(entity = Routes::class,
        parentColumns = arrayOf("route_id"),
        childColumns = arrayOf("route_id"),
        onDelete = ForeignKey.CASCADE)))
class Trips {

    @PrimaryKey(autoGenerate = true)
    var id:Int?=null

    @ColumnInfo(name = "route_id")
    @NotNull
    var routeId:Int?=null

    @ColumnInfo(name = "trip_id")
    @NotNull
    var tripId:Int?=null

    constructor(routeId: Int?, tripId: Int?) {
        this.routeId = routeId
        this.tripId = tripId
    }
}


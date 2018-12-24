package com.aashiyana.androidapp.delhibus.entity

import android.arch.persistence.room.*
import org.jetbrains.annotations.NotNull


@Entity(tableName = "stop_times",
        foreignKeys = arrayOf(ForeignKey(entity = Trips::class,
        parentColumns = arrayOf("trip_id"),
        childColumns = arrayOf("trip_id"))))
class StopTimes {

    @PrimaryKey(autoGenerate = true)
    var id:Int?=null

    @ColumnInfo(name = "trip_id")
    @NotNull
    var tripId:Int?=null

    @ColumnInfo(name = "arrival_time")
    @NotNull
    var arrivalTime:String?=null

    @ColumnInfo(name = "departure_time")
    @NotNull
    var departureTime:String?=null

    @ColumnInfo(name = "stop_id")
    @NotNull
    var stopId:Int?=null

    @ColumnInfo(name = "stop_sequence")
    @NotNull
    var stopSequence:String?=null

    constructor(tripId: Int?,arrivalTime: String?, departureTime: String?, stopId: Int?, stopSequence: String?) {
        this.arrivalTime = arrivalTime
        this.departureTime = departureTime
        this.stopId = stopId
        this.tripId = tripId
        this.stopSequence = stopSequence
    }
}
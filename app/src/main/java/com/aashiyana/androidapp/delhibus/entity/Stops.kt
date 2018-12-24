package com.aashiyana.androidapp.delhibus.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "stops",indices = [Index(value = ["stop_id"], unique = true)])
class Stops:Serializable {

    @PrimaryKey(autoGenerate = true)
    var id:Int?=null

    @ColumnInfo(name = "stop_id")
    @NotNull
    var stopId:Int?=null

    @ColumnInfo(name = "stop_code")
    @NotNull
    var stopCode:String?=null

    @ColumnInfo(name = "stop_name")
    @NotNull
    var stopName:String?=null

    @ColumnInfo(name = "stop_lat")
    var stopLat:String?=null

    @ColumnInfo(name = "stop_long")
    var stopLong:String?=null

    constructor(stopId: Int?, stopCode: String?,stopName: String?, stopLat: String?, stopLong: String?) {
        this.stopId = stopId
        this.stopCode = stopCode
        this.stopName = stopName
        this.stopLat = stopLat
        this.stopLong = stopLong
    }
}
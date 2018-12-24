package com.aashiyana.androidapp.delhibus.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "routes",indices = [(Index(value = "route_id", unique = true))])
class Routes {

    @PrimaryKey(autoGenerate = true)
    var id:Int?=null

    @ColumnInfo(name = "bus_code")
    @NotNull
    var busCode:String?=null

    @ColumnInfo(name = "route_type")
    var routeType:Int?=null

    @ColumnInfo(name = "route_id")
    @NotNull
    var routeId:Int?=null

    constructor(busCode: String?, routeType: Int?, routeId: Int?) {
        this.busCode = busCode
        this.routeType = routeType
        this.routeId = routeId
    }
}


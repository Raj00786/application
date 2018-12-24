package com.aashiyana.androidapp.delhibus.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import com.aashiyana.androidapp.delhibus.R
import com.aashiyana.androidapp.delhibus.entity.Stops
import kotlinx.android.synthetic.main.activity_bus_stops_list.*
import kotlinx.android.synthetic.main.activity_main.*

class BusStopsList : AppCompatActivity() {

    var adapter: Adapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_stops_list)

        val busStopList:ArrayList<Stops> = intent.extras.get("busCode") as ArrayList<Stops>
        var viewList:ArrayList<String> = ArrayList<String>()

        for(busStop in busStopList){
            viewList!!.add(busStop!!.stopName!!)
        }

        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,viewList)
        stopsListView.adapter = adapter as ArrayAdapter<String>

    }
}

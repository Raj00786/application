package com.aashiyana.androidapp.delhibus.activity

import android.arch.persistence.room.Room
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatTextView
import android.util.Log
import android.view.View
import android.widget.*
import com.aashiyana.androidapp.delhibus.AppDatabase
import com.aashiyana.androidapp.delhibus.R
import com.aashiyana.androidapp.delhibus.entity.Routes
import com.aashiyana.androidapp.delhibus.entity.StopTimes
import com.aashiyana.androidapp.delhibus.entity.Stops
import com.aashiyana.androidapp.delhibus.entity.Trips
import kotlinx.android.synthetic.main.activity_bus_stops_list.view.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    var appDatabase: AppDatabase?=null
    var adapter:Adapter?=null
    var routes:ArrayList<String>?=null
    var tempRoutes:ArrayList<String>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java,"delhiBus").allowMainThreadQueries().build()


        routes = appDatabase!!.routesDao().getAllBusCode() as ArrayList<String>

        tempRoutes = routes!!.clone() as ArrayList<String>
        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,tempRoutes)
        busList.adapter = adapter as ArrayAdapter<String>

        busList.setOnItemClickListener(object :AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                var item = (view as AppCompatTextView).text.toString()
                Toast.makeText(applicationContext,item.toString(),Toast.LENGTH_LONG).show()
                var stopsList = appDatabase!!.routesDao().getStopsList(item)
                var intent = Intent(this@MainActivity,BusStopsList::class.java)
                intent.putExtra("busCode",stopsList as ArrayList<Stops>)
                startActivity(intent)

            }
        })

        busSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                var newBusList =  ArrayList<String>()
                for(bus in routes!!){
                    if(bus!!.contains(newText!!)){
                        newBusList.add(bus)
                    }
                }

                tempRoutes!!.clear()
                tempRoutes!!.addAll(newBusList)
                (adapter as ArrayAdapter<String>).notifyDataSetChanged()
                return true
            }

        })
    }

























    fun updateSqliteDatabase(){

        var inputStream:InputStream = resources.openRawResource(R.raw.stops)
        val reader = BufferedReader(InputStreamReader(inputStream))
        reader.readLine()
        var stopsList:MutableList<Stops> = mutableListOf<Stops>()
        var lineread:String = reader.readLine()
        while (lineread!=null) {
            val tokens = lineread.split(",")
            var stops:Stops= Stops(tokens[0].toInt(),tokens[1],tokens[2],tokens[3],tokens[4])
            stopsList!!.add(stops)
            try {
                lineread = reader.readLine()
            }catch (e:Exception){
                Log.d("ERROR FILE",e.toString())
                break;
            }
        }
        appDatabase!!.stopsDao().addAll(stopsList)
        appDatabase!!.stopsDao().getAllStops()


        var inputStream3:InputStream = resources.openRawResource(R.raw.routes)
        val reader3 = BufferedReader(InputStreamReader(inputStream3))
        reader3.readLine()
        var routesList:MutableList<Routes> = mutableListOf<Routes>()
        var lineread3:String = reader3.readLine()
        while (lineread3!=null) {
            val tokens = lineread3.split(",")
            var routes:Routes = Routes(tokens[1],tokens[2].toInt(),tokens[3].toInt())
            routesList!!.add(routes)
            try {
                lineread3 = reader3.readLine()
            }catch (e:Exception){
                Log.d("ERROR FILE",e.toString())
                break;
            }
        }
        appDatabase!!.routesDao().addAll(routesList)

        var inputStream2:InputStream = resources.openRawResource(R.raw.trips)
        val reader2 = BufferedReader(InputStreamReader(inputStream2))
        reader2.readLine()
        var tripsList:MutableList<Trips> = mutableListOf<Trips>()
        var lineread2:String = reader2.readLine()
        while (lineread2!=null) {
            val tokens = lineread2.split(",")
            var trips:Trips = Trips(tokens[0].toInt(),tokens[2].toInt())
            tripsList!!.add(trips)
            try {
                lineread2 = reader2.readLine()
            }catch (e:Exception){
                Log.d("ERROR FILE",e.toString())
                break;
            }
        }
        appDatabase!!.tripsDao().addAll(tripsList)

        var inputStream1:InputStream = resources.openRawResource(R.raw.stop_times)
        val reader1 = BufferedReader(InputStreamReader(inputStream1))
        reader1.readLine()
        var stopTimesList:MutableList<StopTimes> = mutableListOf<StopTimes>()
        var lineread1:String = reader1.readLine()
        while (lineread1!=null) {
            val tokens = lineread1.split(",")
            var stopTimes:StopTimes = StopTimes(tokens[0].toInt(),tokens[1],tokens[2],tokens[3].toInt(),tokens[4])
            stopTimesList!!.add(stopTimes)
            try {
                lineread1 = reader1.readLine()
            }catch (e:Exception){
                Log.d("ERROR FILE",e.toString())
                break;
            }
        }
        appDatabase!!.stopTimesDao().addAll(stopTimesList)

    }
}

package com.equipo1.apppeliculas

import android.net.DnsResolver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.equipo1.apppeliculas.api.apiService
import okhttp3.Callback
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

class mostPopular : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_most_popular)

        var rv: RecyclerView = findViewById(R.id.rvPeliculasPopulares)
        var service=retrofitclient.retrofitInstance?.create(apiService::class.java)
        var datos=service?.getpopular()
        datos?.enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                var cuerpo = response.body()?.string()
                val datosList: ArrayList<Result> = ArrayList()
                var json=cuerpo

                val obj = JSONObject(cuerpo)

                val result = obj.getJSONArray("results")
                for (i in 0 until result.length()) {
                    val result = result.getJSONObject(i)
                    val adult = result.getBoolean("adult")
                    // val backdrop_path=result.getString("backdrop_path")
                    val original_title=result.getString(("original_title"))
                    val overview=result.getString("overview")
                    val poster_path=result.getString("poster_path")
                    val userDetails =Result(original_title,overview,poster_path)
                    datosList.add(userDetails)
                   //tv.setText(""+adult)
                }

                rv.layoutManager = LinearLayoutManager(this@mostPopular)
                rv.adapter = adapter(datosList)

                Toast.makeText(this@mostPopular, "Datos cargados Correctamente" , Toast.LENGTH_SHORT).show()
            }
            //


            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@mostPopular, "error" + t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }
}
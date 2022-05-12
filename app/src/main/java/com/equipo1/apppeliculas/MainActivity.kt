package com.equipo1.apppeliculas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.equipo1.apppeliculas.api.apiService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

        var btnMost_Popular:Button=findViewById(R.id.btnMostPopular)
        btnMost_Popular.setOnClickListener {
            val intent=Intent(this@MainActivity,mostPopular::class.java)
            startActivity(intent)
        }

        var tv:TextView=findViewById(R.id.tvResultado)
        var rv:RecyclerView= findViewById(R.id.rvPeliculas)
        var service=retrofitclient.retrofitInstance?.create(apiService::class.java)
        var datos=service?.getPeliculas()
        datos?.enqueue(object : Callback<ResponseBody> {
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

                }

                rv.layoutManager = LinearLayoutManager(this@MainActivity)
                rv.adapter = adapter(datosList)
                Toast.makeText(this@MainActivity, "Datos cargados correctamente", Toast.LENGTH_SHORT).show()
            }
            //


            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@MainActivity, "error" + t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    }

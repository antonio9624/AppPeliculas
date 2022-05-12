package com.equipo1.apppeliculas.api

import com.equipo1.apppeliculas.datosPelicula
import com.equipo1.apppeliculas.peliculas
import com.equipo1.apppeliculas.results
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface apiService {
    @GET("now_playing?api_key=0d1b2b1734d1da64cf3d65109e061579")
   fun getPeliculas(): Call<ResponseBody>
   @GET("popular?api_key=0d1b2b1734d1da64cf3d65109e061579")
   fun getpopular():Call<ResponseBody>
}
package com.equipo1.apppeliculas

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofitclient{
    private var retrofit:Retrofit?=null
    private var BASE_URL="https://api.themoviedb.org/3/movie/"
    val interceptor = HttpLoggingInterceptor()
    var retrofitInstance: Retrofit? = null
        get() {
        if (retrofit ==null){
            retrofit=retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }


}
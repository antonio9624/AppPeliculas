package com.equipo1.apppeliculas

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.json.JSONArray

data class datosPelicula(
    val dates: Dates,
    val page: Int,
    @SerializedName("results")
    @Expose
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
){

}

package com.equipo1.apppeliculas

import com.google.gson.annotations.SerializedName
class coleccionDatos:ArrayList<peliculas>()

data class peliculas(
    @SerializedName("page") var page: Int,
    @SerializedName("results") var results: results
    )
data class results(
    @SerializedName("backdrop_path") var backdrop_path: String,
    @SerializedName("id") var id: Int,
    @SerializedName("original_title") var original_title: String,
    @SerializedName("overview") var overview: String,
    @SerializedName("release_date") var release_date: String,
    @SerializedName("vote_average") var vote_average: Double

)

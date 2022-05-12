package com.equipo1.apppeliculas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class adapter(val Datos:List<Result>):RecyclerView.Adapter<adapter.datosHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): datosHolder {
        val inflate=LayoutInflater.from(parent.context).inflate(R.layout.item_imagenes,parent,false)
        return datosHolder(inflate)
    }

    override fun getItemCount(): Int =Datos.size

    class datosHolder(val view: View):RecyclerView.ViewHolder(view){

        fun render(result: Result) {
            view.findViewById<TextView>(R.id.txNombre).text=result.original_title
            view.findViewById<TextView>(R.id.txDescripcion).text=result.overview
            Picasso.get().load("https://image.tmdb.org/t/p/w600_and_h900_bestv2/"+result.poster_path).into(view.findViewById<ImageView>(R.id.ivimagenes))
        }
    }

    override fun onBindViewHolder(holder: datosHolder, position: Int) {
        holder.render(Datos[position])
    }
}
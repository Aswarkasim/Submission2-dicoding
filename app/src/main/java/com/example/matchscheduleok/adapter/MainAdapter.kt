package com.example.matchscheduleok.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.matchscheduleok.R
import com.example.matchscheduleok.model.League
import com.squareup.picasso.Picasso

class MainAdapter (private val league: List<League>, private val listener: (League)->Unit ): RecyclerView.Adapter<MainViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.list_liga_row, parent, false))
    }

    override fun getItemCount(): Int {
        return league.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindItem(league[position], listener)
        Glide.with(holder.view.context)
    }

}

class MainViewHolder(val view: View):RecyclerView.ViewHolder(view){

    private val nameLeague = view.findViewById<TextView>(R.id.textView_ligaName)
    private val imageLeague = view.findViewById<ImageView>(R.id.imageView_list_liga_main)

    fun bindItem(league: League, listener: (League) -> Unit){
        nameLeague.text = league.nameLeague
        league.imageLeague?.let { Picasso.get().load(it).fit().into(imageLeague) }
        itemView.setOnClickListener {
            listener(league)
        }
    }
}



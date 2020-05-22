package com.example.matchscheduleok.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.matchscheduleok.R
import com.example.matchscheduleok.adapter.MainAdapter
import com.example.matchscheduleok.adapter.MainViewHolder
import com.example.matchscheduleok.model.League
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private var league: MutableList<League> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        recyclerLiga_main.layoutManager = LinearLayoutManager(this)
        recyclerLiga_main.adapter = MainAdapter(league){
            startActivity<DetailLeagueActivity>(DetailLeagueActivity.EXTRA_DATA to it)
        }
    }

    private fun initData(){
        val idLeague = resources.getStringArray(R.array.liga_id)
        val nameLeague = resources.getStringArray(R.array.liga_name)
        val decriptionLeague = resources.getStringArray(R.array.liga_description)
        val imageLeague = resources.obtainTypedArray(R.array.liga_image)
        league.clear()
        for(i in idLeague.indices){
            league.add(League(idLeague[i], nameLeague[i], decriptionLeague[i], imageLeague.getResourceId(i,0)))
        }

        imageLeague.recycle()
    }
}

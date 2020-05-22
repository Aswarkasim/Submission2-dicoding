package com.example.matchscheduleok.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.matchscheduleok.R
import com.example.matchscheduleok.model.League
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_league.*
import org.jetbrains.anko.startActivity

class DetailLeagueActivity : AppCompatActivity() {

    companion object{
        val EXTRA_DATA = "extra_data"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)

       val dataLeague = intent.getParcelableExtra<League>(EXTRA_DATA) as League
        //Log.d("adakah", "ada dong $dataLeague")

        supportActionBar?.title = dataLeague.nameLeague
        textView_ligaName_detail.text = dataLeague.nameLeague
        textView_description_detail.text = dataLeague.descriptionLeague
        dataLeague.imageLeague?.let { Picasso.get().load(it).fit().into(imageView_detail_league) }

        button_go_to_matchSchedule.setOnClickListener {
            startActivity<MatchActivity>("idLeague" to dataLeague.idLeague, "nameLeague" to dataLeague.nameLeague)
        }
    }
}

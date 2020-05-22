package com.example.matchscheduleok.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.matchscheduleok.R
import com.example.matchscheduleok.api.ApiRepository
import com.example.matchscheduleok.model.MatchModel
import com.example.matchscheduleok.model.TeamItemModel
import com.example.matchscheduleok.presenter.TeamDetailPresenter
import com.example.matchscheduleok.view.DetailView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_match.*

class DetailMatchActivity : AppCompatActivity(), DetailView {

    companion object{
        val EXTRA_DATA_DETAIL = "extra_data_detal"
    }

    private lateinit var presenter: TeamDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        val detailMatch = intent.getParcelableExtra<MatchModel>(EXTRA_DATA_DETAIL)
        Log.d("adakah", "adkah ${detailMatch.strHomeTeam}")

        textView_Home_Team_detail.text = detailMatch.strHomeTeam
        textView_Away_Team_detail.text = detailMatch.strAwayTeam

        textView_away_score_detail.text = detailMatch.intHomeScore
        textView_home_score_detail.text = detailMatch.intAwayScore

        textView_home_defense_detail.text = detailMatch.strHomeLineUpDefense
        textView_home_forward_detail.text = detailMatch.strHomeLineUpForward
        textView_home_goal_keeper_detail.text = detailMatch.strHomeLineUpGoalkeeper
        textView_home_minifield_detail.text = detailMatch.strHomeLineUpMinfield
        textView_home_substitutes_detail.text = detailMatch.strHomeLineUpSubstitutes


        textView_away_substitutes_detail.text = detailMatch.strAwayLineUpSubstitutes
        textView_away_forward_detail.text = detailMatch.strAwayLineUpForward
        textView_away_goal_keeper_detail.text = detailMatch.strHomeLineUpGoalkeeper
        textView_away_minifield_detail.text = detailMatch.strAwayLineUpMinfield
        textView_away_defense_detail.text = detailMatch.strAwayLineUpDefense

        presenter = TeamDetailPresenter(this, ApiRepository(), Gson())
        presenter.getTeamDetails(detailMatch.idHomeTeam, detailMatch.idAwayTeam)


    }

    override fun showTeamDetails(homeBadge: String, awayBadge: String) {
        val homeImage = findViewById<ImageView>(R.id.imageView_logo_team_home_detail)
        val awayImage = findViewById<ImageView>(R.id.imageView_logo_team_away_detail)

        Glide.with(this).load(homeBadge).into(homeImage)
        Glide.with(this).load(awayBadge).into(awayImage)
    }


}

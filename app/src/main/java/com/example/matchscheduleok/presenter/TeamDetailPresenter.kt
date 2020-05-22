package com.example.matchscheduleok.presenter

import com.example.matchscheduleok.api.ApiRepository
import com.example.matchscheduleok.api.TSDBApi
import com.example.matchscheduleok.model.TeamDetailResponse
import com.example.matchscheduleok.view.DetailView
import com.google.gson.Gson
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.uiThread

class TeamDetailPresenter (private val view: DetailView,
                           private val apiRepository: ApiRepository,
                           private val gson: Gson){

    fun getTeamDetails(idHomeTeam: String?,  idAwayTeam: String?){
        async {
            val dataHomeTeam = gson.fromJson(apiRepository
                .doRequest(TSDBApi.getTeamById(idHomeTeam)),TeamDetailResponse::class.java)

            val dataAwayTeam = gson.fromJson(apiRepository
                .doRequest(TSDBApi.getTeamById(idAwayTeam)), TeamDetailResponse::class.java)

            uiThread {
                view.showTeamDetails(dataHomeTeam.teams[0].strTeamBadge!!, dataAwayTeam.teams[0].strTeamBadge!!)
            }
        }
    }
}
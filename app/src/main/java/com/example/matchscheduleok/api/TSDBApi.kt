package com.example.matchscheduleok.api

import com.example.matchscheduleok.BuildConfig

object TSDBApi {
    fun getLastMatch(idLeague: String?): String{
        return BuildConfig.BASE_URL+"api/v1/json/1/eventspastleague.php?id=$idLeague"
    }

    fun getNextMatch(idLeague: String?): String{
        return BuildConfig.BASE_URL+"api/v1/json/1/eventsnextleague.php?id=$idLeague"
    }

    fun getSearchEvent(eventParam: String?): String{
        return BuildConfig.BASE_URL+"api/v1/json/1/searchevents.php?e=$eventParam"
    }

    fun getTeamById(idTeam: String?): String{
        return BuildConfig.BASE_URL+"api/v1/json/1/lookupteam.php?id=$idTeam"
    }
}
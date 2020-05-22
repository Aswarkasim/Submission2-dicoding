package com.example.matchscheduleok.presenter

import android.util.Log
import com.example.matchscheduleok.api.ApiRepository
import com.example.matchscheduleok.api.TSDBApi
import com.example.matchscheduleok.model.MatchResponse
import com.example.matchscheduleok.model.NextResponse
import com.example.matchscheduleok.view.NextView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync

class NextMAtchPresenter(private val view: NextView,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson) {
    fun getNextMatch(idLeague: String?){
        doAsync {
            val data = gson.fromJson(
                apiRepository.doRequest(TSDBApi.getNextMatch(idLeague)),
                NextResponse::class.java
            )
            view.showNextList(data.events)
        }
    }
}
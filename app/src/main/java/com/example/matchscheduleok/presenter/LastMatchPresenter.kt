package com.example.matchscheduleok.presenter

import com.bumptech.glide.Glide
import com.example.matchscheduleok.api.ApiRepository
import com.example.matchscheduleok.api.TSDBApi
import com.example.matchscheduleok.model.MatchResponse
import com.example.matchscheduleok.view.MatchView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LastMatchPresenter(private val view: MatchView,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson) {

    fun getLastMatchList(idLeague: String?){
        //view.showLoading()
        doAsync {
            val data = gson.fromJson(
                apiRepository.doRequest(TSDBApi.getLastMatch(idLeague)),
                MatchResponse::class.java)

            uiThread {
          //      view.hideLoading()
                view.showMatchList(data.events)
            }
        }
    }

    fun getNextMatch(idLeague: String?){
        doAsync {
            val data = gson.fromJson(
                apiRepository.doRequest(TSDBApi.getNextMatch(idLeague)),
                MatchResponse::class.java)

            uiThread {
                view.showMatchList(data.events)
            }
        }
    }
}
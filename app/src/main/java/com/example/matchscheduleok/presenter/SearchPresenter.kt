package com.example.matchscheduleok.presenter

import com.example.matchscheduleok.api.ApiRepository
import com.example.matchscheduleok.api.TSDBApi
import com.example.matchscheduleok.model.MatchModel
import com.example.matchscheduleok.model.SearchResponse
import com.example.matchscheduleok.view.SearchView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class SearchPresenter (private val view: SearchView,
                       private val apiRepository: ApiRepository,
                       private val gson: Gson){
    fun getSearchPresenter(eventParam: String?){
        doAsync {
            val data = gson.fromJson(
                apiRepository.doRequest(TSDBApi.getSearchEvent(eventParam)),
                SearchResponse::class.java)

            uiThread {
                val value: List<MatchModel> = data.event.filter { it.strSport == "Soccer" }
                view.showSearchEvent(value)
            }
        }
    }
}
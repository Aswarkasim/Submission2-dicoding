package com.example.matchscheduleok.view

import com.example.matchscheduleok.model.MatchModel

interface SearchView {
    fun showSearchEvent(data: List<MatchModel>)
}
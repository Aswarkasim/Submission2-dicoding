package com.example.matchscheduleok.view

import com.example.matchscheduleok.model.MatchModel

interface MatchView {
    fun showMatchList(data: List<MatchModel>)
}


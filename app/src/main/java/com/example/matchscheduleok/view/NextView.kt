package com.example.matchscheduleok.view

import com.example.matchscheduleok.model.MatchModel

interface NextView {
    fun showNextList(data: List<MatchModel>)
}

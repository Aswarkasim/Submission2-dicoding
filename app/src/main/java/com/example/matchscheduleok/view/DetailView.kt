package com.example.matchscheduleok.view

import com.example.matchscheduleok.model.TeamItemModel

interface DetailView {

    fun showTeamDetails(homeBadge: String, awayBadge: String)
}
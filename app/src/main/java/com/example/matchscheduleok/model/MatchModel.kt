package com.example.matchscheduleok.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MatchModel(
    var idEvent: String? = null,
    var dateEvent: String? = null,
    val strSport: String? = null,

    var strHomeTeam: String? = null,
    var strAwayTeam: String? = null,

    val idHomeTeam: String? = null,
    val idAwayTeam: String? = null,

    val intHomeScore: String? = null,
    val intAwayScore: String? = null,

    val strHomeGoalDetails: String? = null,
    val strAwaGoalDetails: String? = null,

    val intHomeShots: Int? = null,
    val intAwayShots: Int? = null,

    val strHomeLineUpGoalkeeper: String? = null,
    val strAwayLineUpGoalkeeper: String? = null,

    val strHomeLineUpDefense: String? = null,
    val strAwayLineUpDefense: String? = null,

    val strHomeLineUpMinfield: String? = null,
    val strAwayLineUpMinfield: String? = null,

    val strHomeLineUpForward: String? = null,
    val strAwayLineUpForward: String? = null,

    val strHomeLineUpSubstitutes: String? = null,
    val strAwayLineUpSubstitutes: String? = null
):Parcelable
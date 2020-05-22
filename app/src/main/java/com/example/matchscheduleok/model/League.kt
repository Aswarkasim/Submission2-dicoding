package com.example.matchscheduleok.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class League(
    val idLeague: String?,
    val nameLeague: String?,
    val descriptionLeague: String?,
    val imageLeague: Int?
):Parcelable
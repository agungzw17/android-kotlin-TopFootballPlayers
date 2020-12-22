package com.agung.top10footballplayer.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FootballPlayer(
    var name: String = "",
    var description: String = "",
    var club: String = "",
    var country: String = "",
    var photo: Int = 0,
    var numberTopPlayer: Int = 0,
    var rating: Double = 0.0
): Parcelable
package com.munidigital.bc2201.challenge4.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Crypto(
    val id:Int,
    val name: String,
    val time: String,
    val imgUrl: String,
    val prize: String,
    val abbreviation: String):Parcelable{
}

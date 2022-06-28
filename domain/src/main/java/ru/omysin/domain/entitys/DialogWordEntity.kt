package ru.omysin.domain.entitys

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DialogWordEntity(
    val title: String,
    val translation: String,
    val urlImage: String
) : Parcelable
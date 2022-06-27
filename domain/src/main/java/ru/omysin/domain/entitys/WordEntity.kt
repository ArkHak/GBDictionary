package ru.omysin.domain.entitys

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WordEntity(
    val text: String,
    val meanings: List<MeaningsEntity>?
) : Parcelable
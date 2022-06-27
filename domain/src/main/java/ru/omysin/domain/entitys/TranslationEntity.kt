package ru.omysin.domain.entitys

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TranslationEntity(val text: String?) : Parcelable
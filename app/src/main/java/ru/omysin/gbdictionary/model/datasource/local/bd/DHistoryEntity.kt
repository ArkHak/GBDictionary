package ru.omysin.gbdictionary.model.datasource.local.bd

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "DHistory", indices = [Index(value = arrayOf("word"), unique = true)])
data class DHistoryEntity(
    @field:PrimaryKey @field:ColumnInfo(name = "word") val word: String,
    @field:ColumnInfo(name = "description") val description: String?,
    @field:ColumnInfo(name = "image_url") val imageUrl: String?
)
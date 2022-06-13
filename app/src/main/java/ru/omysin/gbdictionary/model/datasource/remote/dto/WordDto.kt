package ru.omysin.gbdictionary.model.datasource.remote.dto

data class WordDto(
    val text: String?,
    val meanings: List<MeaningsDto>?
)
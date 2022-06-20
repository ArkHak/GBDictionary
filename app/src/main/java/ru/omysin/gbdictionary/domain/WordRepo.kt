package ru.omysin.gbdictionary.domain

import ru.omysin.gbdictionary.domain.entitys.WordEntity

interface WordRepo {
    // (R)
    suspend fun getValuesWord(login: String): List<WordEntity>
}
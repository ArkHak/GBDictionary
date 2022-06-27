package ru.omysin.domain

import ru.omysin.domain.entitys.WordEntity

interface WordRepo {
    // (R)
    suspend fun getValuesWord(login: String): List<WordEntity>
}
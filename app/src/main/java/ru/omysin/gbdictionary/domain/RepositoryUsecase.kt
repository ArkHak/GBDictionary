package ru.omysin.gbdictionary.domain

import ru.omysin.gbdictionary.domain.entitys.WordEntity

interface RepositoryUsecase {
    suspend fun observeWordsList(word: String): List<WordEntity>
}
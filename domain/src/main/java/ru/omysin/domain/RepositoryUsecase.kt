package ru.omysin.domain

import ru.omysin.domain.entitys.WordEntity

interface RepositoryUsecase {
    suspend fun observeWordsList(word: String): List<WordEntity>
}
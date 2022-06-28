package ru.omysin.gbdictionary.model.repousecase

import ru.omysin.domain.RepositoryUsecase
import ru.omysin.domain.WordRepo
import ru.omysin.domain.entitys.WordEntity

class RepositoryUsecaseImpl(private val wordRepo: WordRepo) :
    RepositoryUsecase {
    override suspend fun observeWordsList(word: String): List<WordEntity> {
        return wordRepo.getValuesWord(word)
    }
}

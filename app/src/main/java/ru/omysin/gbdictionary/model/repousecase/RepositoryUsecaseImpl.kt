package ru.omysin.gbdictionary.model.repousecase

import ru.omysin.gbdictionary.domain.RepositoryUsecase
import ru.omysin.gbdictionary.domain.WordRepo
import ru.omysin.gbdictionary.domain.entitys.WordEntity

class RepositoryUsecaseImpl(private val wordRepo: WordRepo) :
    RepositoryUsecase {
    override suspend fun observeWordsList(word: String): List<WordEntity> {
        return wordRepo.getValuesWord(word)
    }
}

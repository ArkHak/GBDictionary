package ru.omysin.gbdictionary.model.repousecase

import io.reactivex.rxjava3.core.Single
import ru.omysin.gbdictionary.domain.RepositoryUsecase
import ru.omysin.gbdictionary.domain.WordRepo
import ru.omysin.gbdictionary.domain.entitys.WordEntity

class RepositoryUsecaseImpl(private val wordRepo: WordRepo) :
    RepositoryUsecase {

    override fun observeWordsList(word: String): Single<List<WordEntity>> {
        return wordRepo.getValuesWord(word)
    }

}

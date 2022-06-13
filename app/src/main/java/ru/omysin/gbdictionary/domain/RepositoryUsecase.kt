package ru.omysin.gbdictionary.domain

import io.reactivex.rxjava3.core.Single
import ru.omysin.gbdictionary.domain.entitys.WordEntity


interface RepositoryUsecase {
    fun observeWordsList(word: String): Single<List<WordEntity>>
}
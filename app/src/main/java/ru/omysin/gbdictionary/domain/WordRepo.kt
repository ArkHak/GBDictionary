package ru.omysin.gbdictionary.domain

import io.reactivex.rxjava3.core.Single
import ru.omysin.gbdictionary.domain.entitys.WordEntity

interface WordRepo {
    // (R)
    fun getValuesWord(login: String): Single<List<WordEntity>>
}
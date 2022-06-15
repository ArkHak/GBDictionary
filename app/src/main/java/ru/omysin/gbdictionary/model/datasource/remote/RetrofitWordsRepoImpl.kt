package ru.omysin.gbdictionary.model.datasource.remote

import io.reactivex.rxjava3.core.Single
import ru.omysin.gbdictionary.domain.WordRepo
import ru.omysin.gbdictionary.domain.entitys.WordEntity

class RetrofitWordsRepoImpl(
    private val api: SkyEngApi
) : WordRepo {
    override fun getValuesWord(login: String): Single<List<WordEntity>> {
        return api.search(login)
    }

}
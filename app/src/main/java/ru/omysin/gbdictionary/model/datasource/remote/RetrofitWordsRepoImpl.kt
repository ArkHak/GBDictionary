package ru.omysin.gbdictionary.model.datasource.remote

import org.koin.core.component.KoinComponent
import ru.omysin.domain.WordRepo
import ru.omysin.domain.entitys.WordEntity

class RetrofitWordsRepoImpl(
    private val api: SkyEngApi
) : WordRepo, KoinComponent {
    override suspend fun getValuesWord(login: String): List<WordEntity> {
        return api.search(login)
    }
}
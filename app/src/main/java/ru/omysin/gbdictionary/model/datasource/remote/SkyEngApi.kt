package ru.omysin.gbdictionary.model.datasource.remote

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.omysin.gbdictionary.domain.entitys.WordEntity

interface SkyEngApi {

    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Single<List<WordEntity>>
}

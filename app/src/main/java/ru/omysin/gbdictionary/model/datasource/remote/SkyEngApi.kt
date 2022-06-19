package ru.omysin.gbdictionary.model.datasource.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.omysin.gbdictionary.domain.entitys.WordEntity

interface SkyEngApi {

    @GET("words/search")
    suspend fun search(@Query("search") wordToSearch: String): List<WordEntity>
}

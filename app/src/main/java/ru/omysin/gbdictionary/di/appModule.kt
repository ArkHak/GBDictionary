package ru.omysin.gbdictionary.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.omysin.gbdictionary.domain.RepositoryUsecase
import ru.omysin.gbdictionary.domain.WordRepo
import ru.omysin.gbdictionary.model.datasource.remote.RetrofitWordsRepoImpl
import ru.omysin.gbdictionary.model.datasource.remote.SkyEngApi
import ru.omysin.gbdictionary.model.repousecase.RepositoryUsecaseImpl
import ru.omysin.gbdictionary.ui.dictionarylist.DictionaryAdapter
import ru.omysin.gbdictionary.ui.dictionarylist.DictionaryViewModel

val appModule = module {
    viewModel { DictionaryViewModel(get((named("repo_usecase")))) }

    single<RepositoryUsecase>(qualifier = named("repo_usecase")) {
        RepositoryUsecaseImpl(get((named("repo_api"))))
    }

    single<WordRepo>(qualifier = named("repo_api")) { RetrofitWordsRepoImpl(get((named("sky_eng_api")))) }
    single<SkyEngApi>(qualifier = named("sky_eng_api")) { get<Retrofit>().create(SkyEngApi::class.java) }
    single {
        Retrofit.Builder()
            .baseUrl(get<String>(qualifier = named("api_url")))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single(qualifier = named("api_url")) { "https://dictionary.skyeng.ru/api/public/v1/" }

    single(qualifier = named("dictionary_adapter_rv")) { DictionaryAdapter() }
}
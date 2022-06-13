package ru.omysin.gbdictionary.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.omysin.gbdictionary.domain.RepositoryUsecase
import ru.omysin.gbdictionary.domain.WordRepo
import ru.omysin.gbdictionary.model.datasource.remote.RetrofitWordsRepoImpl
import ru.omysin.gbdictionary.model.datasource.remote.SkyEngApi
import ru.omysin.gbdictionary.model.repousecase.RepositoryUsecaseImpl
import ru.omysin.gbdictionary.ui.DictionaryViewModel

val appModule = module {
    viewModel { DictionaryViewModel(get()) }

    single<RepositoryUsecase> { RepositoryUsecaseImpl(get()) }

    single<WordRepo> { RetrofitWordsRepoImpl(get()) }
    single<SkyEngApi> { get<Retrofit>().create(SkyEngApi::class.java) }
    single {
        Retrofit.Builder()
            .baseUrl(get<String>(named("api_url")))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    single(named("api_url")) { "https://dictionary.skyeng.ru/api/public/v1/" }
}
package ru.omysin.gbdictionary.di

import androidx.room.Room
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.omysin.domain.RepositoryUsecase
import ru.omysin.domain.WordRepo
import ru.omysin.gbdictionary.model.datasource.local.bd.DHistoryDatabase
import ru.omysin.gbdictionary.model.datasource.local.bd.DHistoryRepo
import ru.omysin.gbdictionary.model.datasource.remote.RetrofitWordsRepoImpl
import ru.omysin.gbdictionary.model.datasource.remote.SkyEngApi
import ru.omysin.gbdictionary.model.repousecase.RepositoryUsecaseImpl
import ru.omysin.gbdictionary.ui.dictionaryhistorilist.DictionaryHistoryAdapter
import ru.omysin.gbdictionary.ui.dictionaryhistorilist.DictionaryHistoryListViewModel
import ru.omysin.gbdictionary.ui.dictionarylist.DictionaryAdapter
import ru.omysin.gbdictionary.ui.dictionarylist.DictionaryListFragment
import ru.omysin.gbdictionary.ui.dictionarylist.DictionaryViewModel

val appModule = module {

    scope(named<DictionaryListFragment>()) {
        viewModel { DictionaryViewModel(get((named("repo_usecase")))) }
        viewModel { DictionaryHistoryListViewModel(get((named("repo_history_bd")))) }
    }

    viewModel { DictionaryHistoryListViewModel(get((named("repo_history_bd")))) }

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
    single(qualifier = named("history_dictionary_adapter_rv")) { DictionaryHistoryAdapter() }

    //BD
    single { Room.databaseBuilder(get(), DHistoryDatabase::class.java, "history_database").build() }
    single(qualifier = named("repo_history_bd")) {
        DHistoryRepo(get((named("history_dao"))))
    }
    single(qualifier = named("history_dao")) { get<DHistoryDatabase>().historyDao() }
}
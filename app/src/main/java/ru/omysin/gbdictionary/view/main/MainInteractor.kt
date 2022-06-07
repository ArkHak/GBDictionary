package ru.omysin.gbdictionary.view.main

import io.reactivex.Observable
import ru.omysin.gbdictionary.model.data.AppState
import ru.omysin.gbdictionary.model.data.DataModel
import ru.omysin.gbdictionary.presenter.Interactor
import ru.omysin.gbdictionary.model.repository.Repo

class MainInteractor(
    private val remoteRepository: Repo<List<DataModel>>,
    private val localRepository: Repo<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}

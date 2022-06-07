package ru.omysin.gbdictionary.model.repository

import io.reactivex.Observable
import ru.omysin.gbdictionary.model.data.DataModel
import ru.omysin.gbdictionary.model.datasource.DataSource

class RepoImpl(private val dataSource: DataSource<List<DataModel>>) :
    Repo<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}

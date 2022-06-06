package ru.omysin.gbdictionary.model.datasource

import io.reactivex.Observable
import ru.omysin.gbdictionary.model.data.DataModel

class DataSourceRemote(private val remoteProvider: RetrofitImpl = RetrofitImpl()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}

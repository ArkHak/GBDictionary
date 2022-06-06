package ru.omysin.gbdictionary.model.datasource

import io.reactivex.Observable
import ru.omysin.gbdictionary.model.data.DataModel
import ru.omysin.gbdictionary.model.data.RoomDataBaseImpl

class DataSourceLocal(private val remoteProvider: RoomDataBaseImpl = RoomDataBaseImpl()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}

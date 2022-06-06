package ru.omysin.gbdictionary.model.data

import io.reactivex.Observable
import ru.omysin.gbdictionary.model.datasource.DataSource

class RoomDataBaseImpl : DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("not implemented")
    }
}

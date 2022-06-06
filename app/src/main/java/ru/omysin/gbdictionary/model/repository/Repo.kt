package ru.omysin.gbdictionary.model.repository

import io.reactivex.Observable

interface Repo<T> {
    fun getData(word: String): Observable<T>
}

package ru.omysin.gbdictionary.presenter

import ru.omysin.gbdictionary.model.data.AppState
import ru.omysin.gbdictionary.view.base.View

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}

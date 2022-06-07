package ru.omysin.gbdictionary.view.base

import ru.omysin.gbdictionary.model.data.AppState

interface View {

    fun renderData(appState: AppState)

}

package ru.omysin.gbdictionary

import android.app.Application
import android.content.Context

class App : Application() {

}

val Context.app: App
    get() = applicationContext as App
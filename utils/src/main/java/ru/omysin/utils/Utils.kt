package ru.omysin.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import ru.omysin.domain.entitys.DHistoryEntity
import ru.omysin.domain.entitys.DialogWordEntity
import ru.omysin.domain.entitys.WordEntity

fun View.hideKeyboard(): Boolean {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    return inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}

fun converterWordEntityToDHistoryEntity(word: WordEntity): DHistoryEntity {
    return DHistoryEntity(
        word = word.text,
        description = word.meanings?.get(0)?.translation?.text,
        imageUrl = word.meanings?.get(0)?.imageUrl
    )
}

fun converterWordEntityToDialogWordEntity(word: WordEntity): DialogWordEntity {
    return DialogWordEntity(
        title = word.text,
        translation = word.meanings?.get(0)?.translation?.text!!,
        urlImage = word.meanings!![0].imageUrl!!
    )
}

fun converterDHistoryEntityToDialogWordEntity(word: DHistoryEntity): DialogWordEntity {
    return DialogWordEntity(
        title = word.word,
        translation = word.description!!,
        urlImage = word.imageUrl!!
    )
}


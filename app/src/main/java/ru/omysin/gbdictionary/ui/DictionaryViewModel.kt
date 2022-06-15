package ru.omysin.gbdictionary.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import ru.omysin.gbdictionary.domain.RepositoryUsecase
import ru.omysin.gbdictionary.domain.entitys.WordEntity

class DictionaryViewModel(
    private val repositoryUsecase: RepositoryUsecase
) : ViewModel() {

    private val _wordsList = MutableLiveData<List<WordEntity>>()
    val wordsList: LiveData<List<WordEntity>> = _wordsList

    private val _inProgress = MutableLiveData<Boolean>()
    val inProgress: LiveData<Boolean> = _inProgress

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun updateWordsListRepo(word: String) {
        _inProgress.postValue(true)
        compositeDisposable.add(
            repositoryUsecase
                .observeWordsList(word)
                .subscribeBy {
                    _inProgress.postValue(false)
                    _wordsList.postValue(it)
                }
        )
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}
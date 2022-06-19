package ru.omysin.gbdictionary.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import ru.omysin.gbdictionary.domain.RepositoryUsecase
import ru.omysin.gbdictionary.domain.entitys.WordEntity

class DictionaryViewModel(
    private val repositoryUsecase: RepositoryUsecase
) : ViewModel() {

    private val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.Main
                + SupervisorJob()
    )

    private val _wordsList = MutableLiveData<List<WordEntity>>()
    val wordsList: LiveData<List<WordEntity>> = _wordsList

    private val _inProgress = MutableLiveData<Boolean>()
    val inProgress: LiveData<Boolean> = _inProgress

    fun updateWordsListRepo(word: String) {
        cancelJob()
        viewModelCoroutineScope.launch {
            startSearch(word)
        }
    }

    private suspend fun startSearch(word: String) = withContext(Dispatchers.IO) {
        _inProgress.postValue(true)
        _wordsList.postValue(repositoryUsecase.observeWordsList(word))
        _inProgress.postValue(false)
    }

    private fun cancelJob() {
        viewModelCoroutineScope.coroutineContext.cancelChildren()
    }

    override fun onCleared() {
        cancelJob()
        super.onCleared()
    }
}
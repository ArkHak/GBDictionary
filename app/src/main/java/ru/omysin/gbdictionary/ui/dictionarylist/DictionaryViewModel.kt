package ru.omysin.gbdictionary.ui.dictionarylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import ru.omysin.domain.RepositoryUsecase
import ru.omysin.domain.entitys.WordEntity

class DictionaryViewModel(
    private val repositoryUsecase: RepositoryUsecase,
) : ViewModel() {

    private val viewModelCoroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var jobVM: Job? = null

    private val _wordsList = MutableLiveData<List<WordEntity>>()
    val wordsList: LiveData<List<WordEntity>> = _wordsList

    private val _inProgress = MutableLiveData<Boolean>()
    val inProgress: LiveData<Boolean> = _inProgress

    fun updateWordsListRepo(word: String) {
        jobVM?.cancelChildren()
        jobVM = viewModelCoroutineScope.launch {
            _inProgress.postValue(true)
            _wordsList.postValue(repositoryUsecase.observeWordsList(word))
            _inProgress.postValue(false)
        }
    }

    override fun onCleared() {
        viewModelCoroutineScope.cancel()
        super.onCleared()
    }
}
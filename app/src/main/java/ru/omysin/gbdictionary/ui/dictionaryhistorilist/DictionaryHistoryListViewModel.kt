package ru.omysin.gbdictionary.ui.dictionaryhistorilist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import ru.omysin.gbdictionary.model.datasource.local.bd.DHistoryEntity
import ru.omysin.gbdictionary.model.datasource.local.bd.DHistoryRepo

class DictionaryHistoryListViewModel(private val dHistoryRepo: DHistoryRepo) : ViewModel() {

    private val viewModelCoroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var jobVM: Job? = null

    private val _wordsHistoryList = MutableLiveData<List<DHistoryEntity>>()
    val wordsHistoryList: LiveData<List<DHistoryEntity>> = _wordsHistoryList

    private val _inProgress = MutableLiveData<Boolean>()
    val inProgress: LiveData<Boolean> = _inProgress

    private val _searchWordInBD = MutableLiveData<DHistoryEntity>()
    val searchWordInBD: LiveData<DHistoryEntity> = _searchWordInBD

    fun allWordsHistoryListRepo() {
        jobVM?.cancelChildren()
        jobVM = viewModelCoroutineScope.launch {
            _inProgress.postValue(true)
            _wordsHistoryList.postValue(dHistoryRepo.getData())
            _inProgress.postValue(false)
        }
    }

    fun saveToBD(wordSave: DHistoryEntity) {
        jobVM?.cancelChildren()
        jobVM = viewModelCoroutineScope.launch {
            dHistoryRepo.saveToBD(wordSave)
        }
    }

    fun searchWordToBD(word: String) {
        jobVM?.cancelChildren()
        jobVM = viewModelCoroutineScope.launch {
            _searchWordInBD.postValue(dHistoryRepo.getDataByWord(word))
        }
    }

    override fun onCleared() {
        viewModelCoroutineScope.cancel()
        super.onCleared()
    }

}
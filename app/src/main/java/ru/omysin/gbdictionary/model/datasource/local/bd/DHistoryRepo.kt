package ru.omysin.gbdictionary.model.datasource.local.bd

import androidx.annotation.WorkerThread
import ru.omysin.domain.entitys.DHistoryEntity

class DHistoryRepo(private val dHistoryDao: DHistoryDao) {

    suspend fun getData(): List<DHistoryEntity> {
        return dHistoryDao.allWords()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun saveToBD(dHistoryEntity: DHistoryEntity) {
        dHistoryDao.insert(dHistoryEntity)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getDataByWord(word: String): DHistoryEntity {
        return dHistoryDao.getDataByWord(word)
    }
}
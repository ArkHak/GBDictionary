package ru.omysin.gbdictionary.model.datasource.local.bd

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.omysin.domain.entitys.DHistoryEntity

@Dao
interface DHistoryDao {
    // Получить весь список слов
    @Query("SELECT * FROM DHistory")
    suspend fun allWords(): List<DHistoryEntity>

    // Получить конкретное слово
    @Query("SELECT * FROM DHistory WHERE word LIKE :word")
    suspend fun getDataByWord(word: String): DHistoryEntity

    // Сохранить новое слово
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: DHistoryEntity)
}
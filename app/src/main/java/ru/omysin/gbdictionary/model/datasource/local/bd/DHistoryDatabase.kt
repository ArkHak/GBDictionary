package ru.omysin.gbdictionary.model.datasource.local.bd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import ru.omysin.domain.entitys.DHistoryEntity

@Database(entities = [DHistoryEntity::class], version = 1, exportSchema = true)
abstract class DHistoryDatabase() : RoomDatabase() {
    abstract fun historyDao(): DHistoryDao

    companion object {
        @Volatile
        private var INSTANCE: DHistoryDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): DHistoryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DHistoryDatabase::class.java,
                    "history_database"
                ).addCallback(DHistoryCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class DHistoryCallback(val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {
            }
        }
    }
}
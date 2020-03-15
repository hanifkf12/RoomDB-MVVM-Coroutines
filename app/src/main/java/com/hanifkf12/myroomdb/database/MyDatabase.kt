package com.hanifkf12.myroomdb.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.hanifkf12.myroomdb.model.Task

@Database(entities = arrayOf(Task::class), version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase(){

    abstract fun taskDao() : TaskDao

    companion object{
        @Volatile
        private var INSTANCE : MyDatabase? = null
        fun getDatabase(context: Context) : MyDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "task_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }

}
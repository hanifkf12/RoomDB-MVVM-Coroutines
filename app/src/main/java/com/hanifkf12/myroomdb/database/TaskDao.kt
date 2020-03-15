package com.hanifkf12.myroomdb.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hanifkf12.myroomdb.model.Task

@Dao
interface TaskDao {
    @Query("SELECT * from task_table ORDER BY id ASC")
    suspend fun getTasks() : List<Task>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: Task)

    @Query("DELETE FROM task_table")
    suspend fun deleteAll()

    @Query("SELECT * from task_table where id = :id")
    suspend fun getTask(id : Int) : Task
}
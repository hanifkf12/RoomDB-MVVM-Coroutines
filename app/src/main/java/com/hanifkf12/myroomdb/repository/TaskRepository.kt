package com.hanifkf12.myroomdb.repository

import com.hanifkf12.myroomdb.database.TaskDao
import com.hanifkf12.myroomdb.model.Task

class TaskRepository(private val taskDao: TaskDao) {
    suspend fun getData(onQuery : (List<Task>) -> Unit){
        val tasks = taskDao.getTasks()
        onQuery(tasks)
    }

    suspend fun insert(task: Task){
        taskDao.insert(task)
    }

    suspend fun getTask(id : Int, onQuery: (Task) -> Unit){
        val task = taskDao.getTask(id)
        onQuery(task)
    }
}
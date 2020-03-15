package com.hanifkf12.myroomdb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hanifkf12.myroomdb.database.MyDatabase
import com.hanifkf12.myroomdb.model.Task
import com.hanifkf12.myroomdb.repository.TaskRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application){
    private val  repository : TaskRepository
    val tasks : MutableLiveData<List<Task>> = MutableLiveData()
    val task : MutableLiveData<Task> = MutableLiveData()
    init {
        val taskDao = MyDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(taskDao)
    }

    fun getTask() = viewModelScope.launch{
        repository.getData {
            tasks.value = it
        }
    }

    fun insert(task: Task) = viewModelScope.launch {
        repository.insert(task)
    }

    fun getSingleTask(id : Int)= viewModelScope.launch{
        repository.getTask(id){
            task.value = it
        }
    }


}
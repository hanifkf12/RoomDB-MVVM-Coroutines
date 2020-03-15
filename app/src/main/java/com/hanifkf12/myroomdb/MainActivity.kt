package com.hanifkf12.myroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hanifkf12.myroomdb.model.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.tasks.observe(this, Observer {
            textCount.text = it.size.toString()
            Log.d("TAG", "${it[it.size-1].id.toString()} ${it[it.size-1].name}" )
        })

        viewModel.task.observe(this, Observer {
            textView.text = it.name
        })

        val task = Task(null,"Mencucui Baju","Hanif")
        button.setOnClickListener {
            viewModel.insert(task)
        }
        load.setOnClickListener {
            viewModel.getTask()
        }
        single.setOnClickListener {
            viewModel.getSingleTask(2)
        }
    }
}

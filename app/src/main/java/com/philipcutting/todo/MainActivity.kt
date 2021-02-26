package com.philipcutting.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.philipcutting.todo.databinding.ActivityMainBinding
import com.philipcutting.todo.models.ToDo
import com.philipcutting.todo.networking.Network
import com.philipcutting.todo.recyclerview.ToDoListAdapter

class MainActivity : AppCompatActivity() {

    private val toDoListAdapter = ToDoListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.todoList.apply {
            adapter = toDoListAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        Network.getToDoItem { toDos ->
            toDoListAdapter.submitList(toDos)
        }

        binding.fab.setOnClickListener {
            val dialog = AddToDoDialog{onAdd(it)}
            dialog.show(supportFragmentManager, "AddToDoDialog")
        }
    }


    private fun onAdd(item: ToDo) {
        Network.addItem(item) {
            toDos ->
            toDoListAdapter.submitList(toDos)
        }
    }

}
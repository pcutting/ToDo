package com.philipcutting.todo.recyclerview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.philipcutting.todo.databinding.TodoItemBinding
import com.philipcutting.todo.models.ToDo

class ToDoListAdapter : ListAdapter<ToDo, ToDoListAdapter.ToDoViewHolder >(diffUtil) {

    companion object{
        private val diffUtil = object : DiffUtil.ItemCallback<ToDo>() {
            override fun areItemsTheSame(oldItem: ToDo, newItem: ToDo) = true

            override fun areContentsTheSame(oldItem: ToDo, newItem: ToDo): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TodoItemBinding.inflate(inflater, parent, false)
        return ToDoViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)
    }


    class ToDoViewHolder (
        private val binding: TodoItemBinding
        ) : RecyclerView.ViewHolder(binding.root) {

            fun onBind(todo: ToDo) {
                binding.apply {
                    this.taskName.text = todo.name
                    priorityImage.setImageResource(todo.priority.drawable)
                }
            }
        }


}
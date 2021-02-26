package com.philipcutting.todo

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import androidx.annotation.IdRes
import androidx.fragment.app.DialogFragment
import com.philipcutting.todo.databinding.DialogAddTodoBinding
import com.philipcutting.todo.models.Priority
import com.philipcutting.todo.models.ToDo

class AddToDoDialog(
    private val onAdd: (ToDo) -> Unit
) : DialogFragment() {



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        Log.d("test", "testing")
        val inflater = LayoutInflater.from(requireContext())
        val binding = DialogAddTodoBinding.inflate(inflater)
        val builder = AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .setPositiveButton(R.string.add) {_,_ ->
                onPositiveSelected(binding)
            }
            .setNegativeButton(R.string.cancel){_,_ ->
                //do nothing
            }

        return builder.create()
    }

    private fun onPositiveSelected(binding: DialogAddTodoBinding) {
        Log.d("test", "testing - onPositiveSelected")
        val name = binding.newTodoNameLayout.editText?.text.toString() ?: ""
        val prioritySelected = binding.priorityButtonGroup.checkedRadioButtonId

        when {
            name.isBlank() -> {
                binding.newTodoNameLayout.error = "Please enter an item"
            }

            prioritySelected == -1 -> {
                binding.newTodoNameLayout.error = "Please select a priority"
            }

            else -> {
                val priority = Priority.from(prioritySelected)
                val toDo = ToDo(name, priority)
                onAdd(toDo)
            }
        }

    }

}
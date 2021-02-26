package com.philipcutting.todo.models

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import com.philipcutting.todo.R

enum class Priority(
    val priorityIndex :Int,
    @DrawableRes val drawable: Int
) {
    HIGH_PRIORITY(0, R.drawable.ic_high_priority),
    MEDIUM_PRIORITY(1, R.drawable.ic_medium_priority),
    LOW_PRIORITY(2, R.drawable.ic_low_priority);

    companion object {
        fun of(priorityIndex: Int) = when (priorityIndex) {
            0 -> HIGH_PRIORITY
            1 -> MEDIUM_PRIORITY
            else -> LOW_PRIORITY
        }

        fun from(@IdRes id: Int) = when  (id) {
            R.id.radio_high_priority -> HIGH_PRIORITY
            R.id.radio_medium_priority -> MEDIUM_PRIORITY
            else -> LOW_PRIORITY
        }
    }
}

data class ToDo (
    val name:String,
    val priority: Priority
)
package me.zeroest.kotlin.basic.migration.controller.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import me.zeroest.kotlin.basic.migration.domain.Todo

data class TodoListResponse(
    val items: List<TodoResponse>,
) {

    val size: Int
        @JsonIgnore
        get() = items.size

    fun get(idx: Int) = items[idx]

    companion object {
        fun of(todoList: List<Todo>): TodoListResponse =
//            TodoListResponse(todoList.map { TodoResponse.of(it) })
            TodoListResponse(todoList.map(TodoResponse::of))
    }

}
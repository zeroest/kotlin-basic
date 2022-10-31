package me.zeroest.kotlin.basic.migration.controller.dto

data class TodoRequest(
    val title: String,
    val description: String,
    val done: Boolean = false,
)

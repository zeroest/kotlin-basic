package me.zeroest.kotlin.basic.migration.controller

import me.zeroest.kotlin.basic.migration.controller.dto.TodoListResponse
import me.zeroest.kotlin.basic.migration.controller.dto.TodoRequest
import me.zeroest.kotlin.basic.migration.controller.dto.TodoResponse
import me.zeroest.kotlin.basic.migration.service.TodoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todos")
class TodoController(
    private val todoService: TodoService,
) {

//    @GetMapping
//    fun getAll(): ResponseEntity<TodoListResponse> {
//        val todos = todoService.findAll()
//        return ResponseEntity.ok(TodoListResponse.of(todos))
//    }
    @GetMapping
    fun getAll(): ResponseEntity<TodoListResponse> =
        ResponseEntity.ok(TodoListResponse.of(todoService.findAll()))

//    @GetMapping("/{id}")
//    operator fun get(@PathVariable id: Long): ResponseEntity<TodoResponse> {
//        val todo = todoService.findById(id)
//        return ResponseEntity.ok(TodoResponse.of(todo))
//    }
    @GetMapping("/{id}")
    operator fun get(@PathVariable id: Long): ResponseEntity<TodoResponse> =
        ResponseEntity.ok(TodoResponse.of(todoService.findById(id)))


//    @PostMapping
//    fun create(@RequestBody request: TodoRequest): ResponseEntity<TodoResponse> {
//        val todo = todoService.create(request)
//        return ResponseEntity.ok(TodoResponse.of(todo))
//    }
    @PostMapping
    fun create(@RequestBody request: TodoRequest) =
        ResponseEntity.ok(TodoResponse.of(todoService.create(request)))

//    @PutMapping("/{id}")
//    fun update(
//        @PathVariable id: Long,
//        @RequestBody request: TodoRequest
//    ): ResponseEntity<TodoResponse> {
//        val todo = todoService.update(id, request)
//        return ResponseEntity.ok(TodoResponse.of(todo))
//    }
    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody request: TodoRequest
    ) = ResponseEntity.ok(TodoResponse.of(todoService.update(id, request)))

//    @DeleteMapping("/{id}")
//    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
//        todoService.delete(id)
//        return ResponseEntity.noContent().build()
//    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        todoService.delete(id)
        return ResponseEntity.noContent().build()
    }

}
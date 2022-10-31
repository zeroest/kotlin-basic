package me.zeroest.kotlin.basic.migration.service

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import me.zeroest.kotlin.basic.migration.domain.Todo
import me.zeroest.kotlin.basic.migration.domain.TodoRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
class TodoServiceTest {

    @MockkBean
    lateinit var todoRepository: TodoRepository

    lateinit var todoService: TodoService

    val stub: Todo by lazy {
        Todo(
            id = 1,
            title = "title",
            description = "description",
            done = false,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
        )
    }

    @BeforeEach
    fun setUp() {
        todoService = TodoService(todoRepository)
    }

    @Test
    fun `한개의 TODO를 반환해야한다`() {
        // Given
        every { todoRepository.findByIdOrNull(1) } returns stub

        // When
        val actual = todoService.findById(1)

        // Then
        assertNotNull(actual)
        assertEquals(actual, stub)
    }

}

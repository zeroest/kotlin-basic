package me.zeroest.kotlin.basic.migration.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "todos")
class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,

    @Column(name = "title")
    var title: String,

    @Lob
    @Column(name = "description")
    var description: String,

    @Column(name = "done")
    var done: Boolean = false,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now(),
) {
    fun update(title: String, description: String, done: Boolean) {
        this.title = title
        this.description = description
        this.done = done
        this.updatedAt = LocalDateTime.now()
    }
}

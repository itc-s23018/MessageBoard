package jp.ac.it_college.std.s23018.messageboard.domain.model

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

data class Messages(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long,

    @Column(name="thread_id", nullable = false)
    val threadId: Long,

    @Column(name="user_id", nullable = false)
    val userId: Long,

    @Column(name = "message", columnDefinition = "TEXT")
    val message: String,

    @Column(name="posted_at", nullable = false)
    val posted_at: LocalDateTime = LocalDateTime.now(),

    @Column(name="updated_at", nullable = false)
    val updated_at: LocalDateTime = LocalDateTime.now(),

    @Column(name = "deleted", nullable = false)
val deleted: Boolean = false

)

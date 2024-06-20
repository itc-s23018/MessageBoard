package jp.ac.it_college.std.s23018.messageboard.domain.model

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

data class Threads(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @Column(name = "title", nullable = false, length = 256)
    val title: String,

    @Column(name ="user_id", nullable = false)
    val userId: Long,

    @Column(name = "create_time", nullable = false)
    val created_at: LocalDateTime = LocalDateTime.now(),

    @Column(name = "update_time", nullable = false)
    val updated_at: LocalDateTime = LocalDateTime.now(),

    @Column(name = "deleted", nullable = false)
    val deleted: Boolean = false
)

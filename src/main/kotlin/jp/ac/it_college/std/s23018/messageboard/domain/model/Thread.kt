package jp.ac.it_college.std.s23018.messageboard.domain.model

import kotlinx.datetime.LocalDateTime

data class Thread(
    val id: Long = 0,
    val title: String,
    val userId: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val deletedAt: LocalDateTime
)

package jp.ac.it_college.std.s23018.messageboard.domain.model

import kotlinx.datetime.LocalDateTime
import java.util.Date

data class Message(
    val id: Long,
    val threadId: Long?,
    val userId: Long?,
    val message: String,
    val posted: LocalDateTime?,
    val updated: LocalDateTime?,
    val deleted: Boolean?

)

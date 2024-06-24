package jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao

import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import java.math.BigInteger

object Message : LongIdTable("message") {
    val threadId = long("thread_id").index()
    val userId = long("user_id").index()
    val message = text("message")
    val postedAt = datetime("post_at").nullable()
    val updatedAt = datetime("updated_at").nullable()
    val delted = bool("delted").default(false)
}
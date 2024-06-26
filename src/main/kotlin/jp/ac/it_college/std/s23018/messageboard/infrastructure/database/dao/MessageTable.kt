package jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object MessageTable : LongIdTable("message") {
    val threadId = long("thread_id").nullable()
    val userId = long("user_id").nullable()
    val message = text("message")
    val posted = datetime("posted").nullable()
    val updated = datetime("updated").nullable()
    val deleted = bool("deleted").nullable()
}
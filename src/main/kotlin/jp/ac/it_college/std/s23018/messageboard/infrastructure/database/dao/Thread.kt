package jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object Thread : LongIdTable("thread") {
    val title = varchar("title", 256).nullable()
    val userId = reference("user_id", Usertable).nullable()
    val createdAt = datetime("created_at").nullable()
    val updatedAt = datetime("updated_at").nullable()
    val deleted = bool("deleted").default(false).nullable()
}
package jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao

import org.jetbrains.exposed.dao.id.LongIdTable

object UserTable : LongIdTable("user") {
    val viewName = varchar("viewName", 32).nullable()
    val email = varchar("email", 256).uniqueIndex().nullable()
    val password = varchar("password", 128).nullable()

}
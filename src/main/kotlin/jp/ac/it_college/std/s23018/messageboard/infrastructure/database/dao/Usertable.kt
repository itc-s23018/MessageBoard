package jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao

import org.bouncycastle.util.test.FixedSecureRandom.BigInteger
import org.jetbrains.exposed.dao.id.LongIdTable

object Usertable : LongIdTable("user") {
    val viewName = varchar("view_name", 32).nullable()
    val email = varchar("email", 256).uniqueIndex().nullable()
    val password = varchar("password", 128).nullable()
}
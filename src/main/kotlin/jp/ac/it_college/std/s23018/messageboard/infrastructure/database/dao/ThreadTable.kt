package jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao

import org.bouncycastle.util.test.FixedSecureRandom.BigInteger
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import java.sql.Types.BIGINT

object ThreadTable : LongIdTable("thread") {
    val title = varchar("title", 256).nullable()
    val userId = long("user_id").nullable()
    val createdAt = datetime("created_at").nullable()
    val updatedAt = datetime("updated_at").nullable()
    val deleted = datetime("deleted_at").nullable()
}
package jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao

import jp.ac.it_college.std.s23018.messageboard.domain.model.User
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UserEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<UserEntity>(UserTable)

    var viewName by UserTable.viewName
    val email by UserTable.email
    val password by UserTable.password


    override fun toString() = """
    UserEntity(id=$id, viewName=$viewName, email=$email, password=$password)
    """.trimIndent()
}

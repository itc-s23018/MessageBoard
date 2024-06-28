package jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ThreadEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object: LongEntityClass<ThreadEntity>(ThreadTable)

    var title by ThreadTable.title
    var userId by ThreadTable.userId
    var createdAt  by ThreadTable.createdAt
    var updatedAt by ThreadTable.updatedAt
    var deleted by ThreadTable.deleted


}
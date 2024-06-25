package jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ThreadEntity(id: EntityID<Long>) : LongEntity(id){
    companion object : LongEntityClass<ThreadEntity>(Thread)

    var title by Thread.title
    var userId by Thread.userId
    var createdAt by Thread.createdAt
    var updatedAt by Thread.updatedAt
    var deleted by Thread.deleted

}
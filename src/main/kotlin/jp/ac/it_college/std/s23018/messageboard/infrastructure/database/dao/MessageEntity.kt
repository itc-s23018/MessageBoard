package jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class MessageEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<MessageEntity>(Message)

    var threadId by Message.threadId
    var userId by Message.userId
    var message  by Message.message
    var postedAt by Message.postedAt
    var updatedAt by Message.updatedAt
    var deleted by Message.delted
}
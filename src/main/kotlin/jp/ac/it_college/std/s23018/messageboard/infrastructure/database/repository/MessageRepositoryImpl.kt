package jp.ac.it_college.std.s23018.messageboard.infrastructure.database.repository

import jp.ac.it_college.std.s23018.messageboard.domain.model.Message
import jp.ac.it_college.std.s23018.messageboard.domain.repository.MessageRepository
import jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao.MessageEntity
import jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao.MessageTable
import jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao.MessageTable.threadId
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class MessageRepositoryImpl : MessageRepository {
    override fun newPost(message: Message) {
        transaction {
            MessageTable. {
                threadId = message.threadId

            }
        }
    }


    override fun updateMessage(id: Long): Message? {
        MessageEntity.findById(id)?.apply {
            message?. let { this?.message = it}
            userId?.let { this?.userId = it }
            updated?.let { this?.updated = it }
        }
    }

    override fun deleteMessage(messageId: Long): Message? {
        MessageEntity.findById(messageId)
    }
}
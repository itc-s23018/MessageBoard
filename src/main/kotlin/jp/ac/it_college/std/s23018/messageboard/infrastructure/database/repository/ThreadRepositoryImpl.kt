package jp.ac.it_college.std.s23018.messageboard.infrastructure.database.repository

import jp.ac.it_college.std.s23018.messageboard.domain.model.Thread
import jp.ac.it_college.std.s23018.messageboard.domain.repository.ThreadRepository
import jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao.ThreadEntity
import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.sql.transactions.transaction

class ThreadRepositoryImpl : ThreadRepository {
    override fun getThreads(): List<Thread> {
        return transaction {
            ThreadEntity.all().map(::toModel)
        }
    }

    override fun post(thread: Thread) {
        transaction {
            ThreadEntity.new {
                title = thread.title
                userId = thread.userId
                createdAt = thread.createdAt
            }
        }
    }

    override fun update(id: Long, tittle: String) {
        ThreadEntity.findById(id)?.apply {
            title?. let { this?.title = it }
            userId?.let { this?.userId = it }
            updatedAt?. let { this?.updatedAt = it }
        }
    }

    override fun delete(id: Long) {
        ThreadEntity.findById(id)?.delete()
    }


    private fun toModel(thread: ThreadEntity): Thread {
        val thread = Thread(
            thread.id.value,
            thread.title,
            thread.createdAt,
        )
        return thre
    }
}
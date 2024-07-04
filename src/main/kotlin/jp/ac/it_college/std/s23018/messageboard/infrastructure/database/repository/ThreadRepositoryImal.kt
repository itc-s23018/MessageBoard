package jp.ac.it_college.std.s23018.messageboard.infrastructure.database.repository

import jp.ac.it_college.std.s23018.messageboard.domain.model.Thread
import jp.ac.it_college.std.s23018.messageboard.domain.repository.ThreadRepository
import jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao.ThreadEntity
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class ThreadRepositoryImal : ThreadRepository {


    override fun newPost(thread: Thread) {
        transaction {
            ThreadEntity.new(thread.id) {
                userId = thread.userId
                title = thread.title
                createdAt = thread.createdAt
            }
        }
    }

    override fun update(thread: Thread) {
        ThreadEntity.findById(thread.id)?.apply {
            title?. let { this.title = it }
            userId?. let { this.userId = it}
            updatedAt?. let { this.updatedAt = it }

        }
    }

    override fun delete(thread: Thread) {
            ThreadEntity.findById(thread.id)?.delete()
    }

}

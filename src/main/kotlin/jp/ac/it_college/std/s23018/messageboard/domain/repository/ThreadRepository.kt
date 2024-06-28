package jp.ac.it_college.std.s23018.messageboard.domain.repository

import jp.ac.it_college.std.s23018.messageboard.domain.model.Thread

interface ThreadRepository {
    fun getThreads(): List<Thread>

    fun post(thread: Thread)

    fun update(id: Long, tittle: String)

    fun delete(id: Long,)
}
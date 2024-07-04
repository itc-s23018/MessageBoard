package jp.ac.it_college.std.s23018.messageboard.domain.repository

import jp.ac.it_college.std.s23018.messageboard.domain.model.Thread

interface ThreadRepository {
    fun newPost(thread: Thread)
    fun update(thread: Thread)
    fun delete(thread: Thread)
}
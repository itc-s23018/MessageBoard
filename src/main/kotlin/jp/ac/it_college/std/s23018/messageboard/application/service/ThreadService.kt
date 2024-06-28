package jp.ac.it_college.std.s23018.messageboard.application.service

import jp.ac.it_college.std.s23018.messageboard.domain.repository.ThreadRepository
import kotlinx.datetime.LocalDateTime
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ThreadService(
    private val threadRepository: ThreadRepository
) {
    @Transactional
    fun getList() : List<jp.ac.it_college.std.s23018.messageboard.domain.model.Thread> {
        return threadRepository.getThreads()
    }


    @Transactional
    fun newPost(title: String, UserId: Long, createdAt: LocalDateTime): Long {
        val thread = Thread(title, UserId, createdAt)
        threadRepository.post(thread)
    }

    @Transactional
    fun updateTitle(id: Long, title: String, userId: Long) {
        val thread = jp.ac.it_college.std.s23018.messageboard.domain.model.Thread(id, title, userId)
        threadRepository.update(thread)
    }

    @Transactional
    fun delete(id: Long, userId: Long) {
        val thread = (id, userId)
        threadRepository.delete(thread)
    }

}
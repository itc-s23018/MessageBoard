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
    fun newPost(thread: Thread) {
        threadRepository.newPost(thread)
    }

    @Transactional
    fun updateTitle(id: Long, title: String, updateAt: LocalDateTime){
        threadRepository.update(id, title, updateAt)
    }

    @Transactional
    fun delete(id: Long){
        threadRepository.delete(id)
    }
}
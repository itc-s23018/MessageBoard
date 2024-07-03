package jp.ac.it_college.std.s23018.messageboard.domain.repository

import jp.ac.it_college.std.s23018.messageboard.domain.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository {
    fun save(user:User)
    fun find(viewName: String): User?
}
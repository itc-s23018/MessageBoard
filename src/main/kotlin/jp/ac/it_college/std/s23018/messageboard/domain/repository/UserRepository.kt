package jp.ac.it_college.std.s23018.messageboard.domain.repository

import jp.ac.it_college.std.s23018.messageboard.domain.model.User

interface UserRepository {
    fun findByEmail(email: String): User?
}
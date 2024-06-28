package jp.ac.it_college.std.s23018.messageboard.application.service

import jp.ac.it_college.std.s23018.messageboard.domain.model.User
import jp.ac.it_college.std.s23018.messageboard.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val userRepository: UserRepository
) {
    fun findUser(email: String): User? {
        return userRepository.findByUsername(email)
    }
}
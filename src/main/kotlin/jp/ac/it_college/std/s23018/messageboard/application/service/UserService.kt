package jp.ac.it_college.std.s23018.messageboard.application.service

import jp.ac.it_college.std.s23018.messageboard.domain.model.User
import jp.ac.it_college.std.s23018.messageboard.domain.repository.UserRepository
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
) {
   @Transactional
   fun register(viewName: String, email: String, password: String) {
       val user =  User(id = 0, viewName, email, password)
       userRepository.save(user)
   }

    @Transactional
    fun find(id: Long): User {
        return userRepository.find(id) ?: throw UsernameNotFoundException("ユーザーが見つかりません")
    }
}
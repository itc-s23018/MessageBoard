package jp.ac.it_college.std.s23018.messageboard.application.service

import jp.ac.it_college.std.s23018.messageboard.domain.model.User
import jp.ac.it_college.std.s23018.messageboard.domain.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
) {
  @Transactional
  fun register(user : User) {
      userRepository.save(user)
  }
}
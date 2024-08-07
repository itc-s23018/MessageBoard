package jp.ac.it_college.std.s23018.messageboard.infrastructure.database.repository

import jp.ac.it_college.std.s23018.messageboard.domain.model.User
import jp.ac.it_college.std.s23018.messageboard.domain.repository.UserRepository
import jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao.UserEntity
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImal : UserRepository {


    override fun save(user: User) {
        transaction {
            UserEntity.new {
                viewName = user.viewName
                email = user.email
                password = user.password
            }
        }
    }
}
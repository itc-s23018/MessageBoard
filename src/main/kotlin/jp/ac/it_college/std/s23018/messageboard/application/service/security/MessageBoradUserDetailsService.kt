package jp.ac.it_college.std.s23018.messageboard.application.service.security

import jp.ac.it_college.std.s23018.messageboard.application.service.AuthenticationService
import jp.ac.it_college.std.s23018.messageboard.domain.model.User
import jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao.UserTable.email
import jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao.UserTable.password
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

class MessageBoardUserDetailsService(
    private val authenticationService: AuthenticationService
) : UserDetailsService {
    override fun loadUserByUsername(viewName: String?): UserDetails {
        viewName ?: throw UsernameNotFoundException("ユーザー名が空です")

        val user = authenticationService.findUserByViewName(viewName)
            ?: throw UsernameNotFoundException("$viewName に該当するユーザーはいません")

        return MessageBoradUserDetails(user)
    }

    data class MessageBoradUserDetails(
        val viewName: String,
        val email: String,
        val password: String,
    ) : UserDetails {
        constructor(user: User) : this(user.viewName, user.email, user.password)

        override fun getAuthorities(): MutableCollection<out GrantedAuthority> {

        }

        override fun getPassword(): String {
            return password
        }

        override fun getUsername(): String {
            return email
        }
    }

    data class MessageBoardUserDetails(
        val id: Long,
        val viewName: String,
        val email: String,
        val password: String,
    ) : UserDetails {
        constructor(user: User) : this(user.viewName, user.email,user.password)

        override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
            TODO("Not yet implemented")
        }

        override fun getPassword(): String {
            return password
        }

        override fun getUsername(): String {
            return email
        }
    }

}
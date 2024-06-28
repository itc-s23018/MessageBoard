package jp.ac.it_college.std.s23018.messageboard.application.service.security

import jp.ac.it_college.std.s23018.messageboard.application.service.AuthenticationService
import jp.ac.it_college.std.s23018.messageboard.domain.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

class MessageBoardUserDetailsService(
    private val authenticationService: AuthenticationService
): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        username ?: throw UsernameNotFoundException("メールアドレスが空です")

        val user = authenticationService.findUser(username)
            ?: throw UsernameNotFoundException("$username に該当するユーザはいません")
        return MessageBoardUserDetails(user)
    }

    data class MessageBoardUserDetails(
        val id: Long,
        val viewName: String,
        val email: String,
        var password: String,
    ) : UserDetails {
        constructor(user: User) : this(user.id, user.viewName, user.email, user.password)




        override fun getPassword(): String {
            return password
        }

        override fun getUsername(): String {
            return email
        }

        override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
            return mutableListOf<GrantedAuthority>()
        }
    }

}
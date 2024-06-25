package jp.ac.it_college.std.s23018.messageboard.domain.model

import kotlinx.serialization.Serializable


data class User(
    val id: Long? = null,
    val viewName: String?,
    val email: String?,
    val password: String?,
)


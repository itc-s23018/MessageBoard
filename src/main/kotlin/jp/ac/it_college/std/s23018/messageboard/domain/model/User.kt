package jp.ac.it_college.std.s23018.messageboard.domain.model


data class User(
    val id: Long = 0,
    val viewName: String,
    val email: String,
    val password: String,
)

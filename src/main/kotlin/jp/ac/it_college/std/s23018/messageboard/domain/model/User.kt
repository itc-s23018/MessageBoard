package jp.ac.it_college.std.s23018.messageboard.domain.model

data class User(
    val viewName: String,
    val email: String,
    var password: String,
)

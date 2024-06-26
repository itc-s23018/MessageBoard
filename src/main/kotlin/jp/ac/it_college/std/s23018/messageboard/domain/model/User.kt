package jp.ac.it_college.std.s23018.messageboard.domain.model

import org.bouncycastle.util.test.FixedSecureRandom.BigInteger

data class User(
    val id: Long,
    val viewName: String,
    val email: String,
    val password: String,
)

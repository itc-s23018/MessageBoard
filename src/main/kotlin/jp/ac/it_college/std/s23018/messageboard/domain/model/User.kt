package jp.ac.it_college.std.s23018.messageboard.domain.model

import jakarta.persistence.*

data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    val id: Long = 0,

    @Column(nullable = false, length = 32)
    val viewName: String,

    @Column(nullable = false, unique = true, length = 256)
    val email: String,

    @Column(nullable = false, length = 128)
    val password: String,
)

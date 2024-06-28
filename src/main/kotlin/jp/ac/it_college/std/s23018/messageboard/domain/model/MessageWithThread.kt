package jp.ac.it_college.std.s23018.messageboard.domain.model

data class MessageWithThread(
    val message: Message,
    val thread: Thread?
)

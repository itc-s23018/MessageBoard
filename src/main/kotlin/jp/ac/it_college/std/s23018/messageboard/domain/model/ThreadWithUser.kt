package jp.ac.it_college.std.s23018.messageboard.domain.model

data class ThreadWithUser(
    val thread: Thread,
    val user: User?
){

}
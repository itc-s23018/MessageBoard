package jp.ac.it_college.std.s23018.messageboard.domain.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.CONFLICT)
class EmailAlreadyInUseException(override val message: String ) : Exception()
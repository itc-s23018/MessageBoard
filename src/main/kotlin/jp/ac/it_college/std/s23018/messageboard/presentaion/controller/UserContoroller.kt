package jp.ac.it_college.std.s23018.messageboard.presentaion.controller

import jp.ac.it_college.std.s23018.messageboard.application.service.UserService
import jp.ac.it_college.std.s23018.messageboard.domain.model.User
import jp.ac.it_college.std.s23018.messageboard.presentaion.from.PostUserRegisterRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
@CrossOrigin
class UserController(
    private val userService: UserService,
) {
    @PostMapping("/register")
    fun register(@RequestBody user: PostUserRegisterRequest) {
        val user = User(
            viewName =user.viewName,
            email = user.email,
            password = user.password
        )
        userService.register(user)
    }
}
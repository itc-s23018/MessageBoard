package jp.ac.it_college.std.s23018.messageboard.presentaion.controller

import jp.ac.it_college.std.s23018.messageboard.application.service.UserService
import jp.ac.it_college.std.s23018.messageboard.application.service.security.MessageBoardUserDetailsService
import jp.ac.it_college.std.s23018.messageboard.presentaion.from.GetUserInfoResponse
import jp.ac.it_college.std.s23018.messageboard.presentaion.from.PostUserRegisterRequest
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
@CrossOrigin
class UserController(
    private val userService: UserService,
) {
    @PostMapping("/register")
    fun register(@RequestBody user: PostUserRegisterRequest) {
        user.run {
            userService.register(viewName, email, password)
        }
    }

    @GetMapping("/info")
    fun getInfo(
        @AuthenticationPrincipal user: MessageBoardUserDetailsService.MessageBoardUserDetails
    ): GetUserInfoResponse {
        return userService.find(user.id).run {
            GetUserInfoResponse(id, viewName)
        }
    }
}
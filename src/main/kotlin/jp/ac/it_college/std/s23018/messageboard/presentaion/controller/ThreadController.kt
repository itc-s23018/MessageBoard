package jp.ac.it_college.std.s23018.messageboard.presentaion.controller

import jp.ac.it_college.std.s23018.messageboard.application.service.ThreadService
import jp.ac.it_college.std.s23018.messageboard.application.service.security.MessageBoardUserDetailsService
import jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao.ThreadTable.title
import jp.ac.it_college.std.s23018.messageboard.infrastructure.database.dao.ThreadTable.updatedAt
import jp.ac.it_college.std.s23018.messageboard.presentaion.from.*
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/threads")
@CrossOrigin
class ThreadController(
    private val service: ThreadService
) {
    @GetMapping("/list")
    fun getList(): GetThreadListResponse {
        val threadList = service.getList().map(::ThreadInfo)
        return GetThreadListResponse(threadList)
    }

    @PostMapping("/create")
    fun create(
        @RequestBody body: PostThreadRequest,
        @AuthenticationPrincipal user: MessageBoardUserDetailsService.MessageBoardUserDetails
    ): CreatedThreadResponse {
        val newId = service.newPost(body.title, body.message, user.id)
        return CreatedThreadResponse(newId)
    }

    @PutMapping("/update/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody body: PutThreadUpdateRequest,
        @AuthenticationPrincipal user: MessageBoardUserDetailsService.MessageBoardUserDetails
    ): ThreadUpdateResponse {
        val thread = service.updateTitle(id, body.title, user.id)
        return thread.run { ThreadUpdateResponse(id, title) }
    }

    @DeleteMapping("/delete/{id}")
    fun deleteThread(
        @PathVariable id: Long,
        @AuthenticationPrincipal user: MessageBoardUserDetailsService.MessageBoardUserDetails
    ): ThreadDeleteResponse {
        val result = service.delete(id, user.id)
        return result.run {
            ThreadDeleteResponse(id, title, updatedAt)
        }
    }
}
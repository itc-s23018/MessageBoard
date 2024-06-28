package jp.ac.it_college.std.s23018.messageboard.domain.repository

import jp.ac.it_college.std.s23018.messageboard.domain.model.Message

interface MessageRepository  {
  fun newPost(message: Message): Message?
  fun updateMessage(threadId: Long): Message?
  fun deleteMessage(messageId: Long): Message?
}
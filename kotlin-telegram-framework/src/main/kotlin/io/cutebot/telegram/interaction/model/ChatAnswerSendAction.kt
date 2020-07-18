package io.cutebot.telegram.interaction.model

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.TgChatAction


class ChatAnswerSendAction private constructor(
        private val action: String
): ChatAnswer {
    fun getChatAction(chatId: Long): TgChatAction {
        return TgChatAction(chatId, action)
    }

    override fun fireAction(api: TelegramApi, token: String, chatId: Long) {
        api.sendChatAction(token, getChatAction(chatId))
    }

    companion object {
        fun typing(): ChatAnswerSendAction {
            return ChatAnswerSendAction("typing")
        }
        fun uploadPhoto(): ChatAnswerSendAction {
            return ChatAnswerSendAction("upload_photo")
        }
        fun recordVideo(): ChatAnswerSendAction {
            return ChatAnswerSendAction("record_video")
        }
        fun uploadVideo(): ChatAnswerSendAction {
            return ChatAnswerSendAction("upload_video")
        }
        fun recordAudio(): ChatAnswerSendAction {
            return ChatAnswerSendAction("record_audio")
        }
        fun uploadAudio(): ChatAnswerSendAction {
            return ChatAnswerSendAction("upload_audio")
        }
        fun uploadDocument(): ChatAnswerSendAction {
            return ChatAnswerSendAction("upload_document")
        }
        fun findLocation(): ChatAnswerSendAction {
            return ChatAnswerSendAction("find_location")
        }
        fun recordVideoNote(): ChatAnswerSendAction {
            return ChatAnswerSendAction("record_video_note")
        }
        fun uploadVideoNote(): ChatAnswerSendAction {
            return ChatAnswerSendAction("upload_video_note")
        }
    }
}

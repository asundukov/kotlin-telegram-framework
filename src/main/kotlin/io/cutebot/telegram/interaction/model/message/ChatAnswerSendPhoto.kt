package io.cutebot.telegram.interaction.model.message

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.TgSendPhoto
import java.io.File

class ChatAnswerSendPhoto(
        private val file: File,
        private val caption: String = ""
): ChatAnswerSendMessage {
    override fun getSendMessage(chatId: Long): TgSendPhoto {
        return TgSendPhoto(
                chatId = chatId,
                photo = file,
                caption = caption
        )
    }

    override fun fireAction(api: TelegramApi, token: String, chatId: Long) {
        api.sendPhoto(token, getSendMessage(chatId))
    }
}

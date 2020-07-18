package io.cutebot.telegram.interaction.model.message

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.TgSendDocument
import io.cutebot.telegram.client.model.keyboard.TgKeyboard
import java.io.File

class ChatAnswerSendDocument(
        private val file: File,
        private val caption: String = "",
        private val keyboard: TgKeyboard? = null
): ChatAnswerSendMessage {
    override fun getSendMessage(chatId: Long): TgSendDocument {
        return TgSendDocument(
                chatId = chatId,
                document = file,
                caption = caption,
                replyMarkup = keyboard
        )
    }

    override fun fireAction(api: TelegramApi, token: String, chatId: Long) {
        api.sendDocument(token, getSendMessage(chatId))
    }
}

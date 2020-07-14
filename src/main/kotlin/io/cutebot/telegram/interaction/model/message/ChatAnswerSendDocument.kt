package io.cutebot.telegram.interaction.model.message

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.TgSendDocument
import java.io.File

class ChatAnswerSendDocument(
        private val file: File,
        private val caption: String = ""
): ChatAnswerSendMessage {
    override fun getSendMessage(chatId: Long): TgSendDocument {
        return TgSendDocument(
                chatId = chatId,
                document = file,
                caption = caption
        )
    }

    override fun fireAction(api: TelegramApi, token: String, chatId: Long) {
        api.sendDocument(token, getSendMessage(chatId))
    }
}

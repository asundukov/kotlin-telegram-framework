package io.cutebot.telegram.interaction.model.message

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.TgSendTextMessage

class ChatAnswerSendText(
        private val text: String
): ChatAnswerSendMessage {
    override fun getSendMessage(chatId: Long): TgSendTextMessage {
        return TgSendTextMessage(
                chatId = chatId,
                text = text
        )
    }

    override fun fireAction(api: TelegramApi, token: String, chatId: Long) {
        api.sendMessage(token, getSendMessage(chatId))
    }

}

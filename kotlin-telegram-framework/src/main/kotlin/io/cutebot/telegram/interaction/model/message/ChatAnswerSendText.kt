package io.cutebot.telegram.interaction.model.message

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.TgSendTextMessage
import io.cutebot.telegram.client.model.keyboard.TgKeyboard

class ChatAnswerSendText(
        private val text: String,
        private val replyKeyboardMarkup: TgKeyboard? = null
): ChatAnswerSendMessage {
    override fun getSendMessage(chatId: Long): TgSendTextMessage {

        return TgSendTextMessage(
                chatId = chatId,
                text = text,
                replyMarkup = replyKeyboardMarkup
        )
    }

    override fun fireAction(api: TelegramApi, token: String, chatId: Long) {
        api.sendMessage(token, getSendMessage(chatId))
    }

}

package io.cutebot.telegram.interaction.model.message

import io.cutebot.telegram.client.model.TgSendMessage
import io.cutebot.telegram.interaction.model.ChatAnswer


interface ChatAnswerSendMessage: ChatAnswer {
    fun getSendMessage(chatId: Long): TgSendMessage
}

package io.cutebot.telegram.interaction.model

import io.cutebot.telegram.client.TelegramApi

class ChatAnswerNothing: ChatAnswer {
    override fun fireAction(api: TelegramApi, token: String, chatId: Long) {
    }
}

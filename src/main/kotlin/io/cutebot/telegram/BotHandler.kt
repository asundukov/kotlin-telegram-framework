package io.cutebot.telegram

import io.cutebot.telegram.client.model.TgMessage
import io.cutebot.telegram.interaction.model.ChatAnswer

interface BotHandler {
    fun handleMessage(message: TgMessage): ChatAnswer
}

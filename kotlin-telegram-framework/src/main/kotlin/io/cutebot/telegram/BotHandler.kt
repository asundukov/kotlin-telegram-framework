package io.cutebot.telegram

import io.cutebot.telegram.bot.model.RawMessage
import io.cutebot.telegram.interaction.model.ChatAnswer

interface BotHandler {
    fun handleMessage(message: RawMessage): ChatAnswer
}

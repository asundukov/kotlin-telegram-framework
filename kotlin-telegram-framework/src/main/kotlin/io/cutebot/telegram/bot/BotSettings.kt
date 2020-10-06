package io.cutebot.telegram.bot

import io.cutebot.telegram.bot.model.settings.ChatMessagesStrategy

data class BotSettings(
     val chatMessagesStrategy: ChatMessagesStrategy = ChatMessagesStrategy.IGNORE
)

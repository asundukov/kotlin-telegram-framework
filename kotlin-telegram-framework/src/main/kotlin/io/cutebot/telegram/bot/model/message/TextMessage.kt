package io.cutebot.telegram.bot.model.message

import io.cutebot.telegram.bot.model.Message

class TextMessage(
        message: RawMessage,
        val text: String
): Message(message)

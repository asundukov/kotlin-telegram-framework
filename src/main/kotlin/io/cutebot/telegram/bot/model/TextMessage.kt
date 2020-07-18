package io.cutebot.telegram.bot.model

class TextMessage(
        message: RawMessage,
        val text: String
): Message(message)

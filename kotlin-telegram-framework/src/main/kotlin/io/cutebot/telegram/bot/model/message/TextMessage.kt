package io.cutebot.telegram.bot.model.message

class TextMessage(
        message: RawMessage,
        val text: String
): Message(message)

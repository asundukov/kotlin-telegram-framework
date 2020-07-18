package io.cutebot.telegram.bot.model

import io.cutebot.telegram.client.model.TgDocument

class DocumentMessage(
        message: RawMessage,
        tgDocument: TgDocument
): Message(message) {
    val document: Document = Document(tgDocument, message.telegramApi, message.botToken)
}

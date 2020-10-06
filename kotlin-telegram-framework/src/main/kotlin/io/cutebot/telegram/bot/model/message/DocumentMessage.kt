package io.cutebot.telegram.bot.model.message

import io.cutebot.telegram.bot.model.Document
import io.cutebot.telegram.bot.model.Message
import io.cutebot.telegram.client.model.TgDocument

class DocumentMessage(
        message: RawMessage,
        tgDocument: TgDocument
): Message(message) {
    val document: Document = Document(tgDocument, message.telegramApi, message.botToken)
    val message = message.caption ?: ""
}

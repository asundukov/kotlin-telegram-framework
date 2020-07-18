package io.cutebot.telegram.bot.model

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.TgMessage
import java.util.Calendar

abstract class Message internal constructor(message: RawMessage) {
    val date: Calendar = Calendar.getInstance()
    val user: User? = User.create(message.from)
    val chat: Chat = Chat.create(message.chat)

    val forwardFromUser: User? = User.create(message.forwardFrom)
    val forwardFromChat: Chat? = Chat.createNullable(message.forwardFromChat)
    val forwardFromDate: Calendar?
    val forwardFromMessageId: Long? = message.forwardFromMessageId
    val forwardFromSenderName: String? = message.forwardSenderName
    val forwardFromSignature: String? = message.forwardSignature

    val viaBot: User? = User.create(message.viaBot)

    val authorSignature: String? = message.authorSignature
    val editDate: Calendar?

    val replyTo: Message? = create(message.replyToMessage, message.telegramApi, message.botToken)

    init {
        date.timeInMillis = message.date

        if (message.forwardDate != null) {
            forwardFromDate = Calendar.getInstance()
            forwardFromDate.timeInMillis = message.forwardDate
        } else {
            forwardFromDate = null
        }

        if (message.forwardDate != null) {
            editDate = Calendar.getInstance()
            editDate.timeInMillis = message.forwardDate
        } else {
            editDate = null
        }
    }

    companion object {
        fun create(tgMessage: TgMessage?, telegramApi: TelegramApi, botToken: String): Message? {
            tgMessage ?: return null
            if (tgMessage.text != null) {
                return TextMessage(RawMessage(tgMessage, telegramApi, botToken), tgMessage.text)
            }

            if (tgMessage.photo != null) {
                return PhotoMessage(RawMessage(tgMessage, telegramApi, botToken), tgMessage.photo)
            }

            if (tgMessage.document != null) {
                return DocumentMessage(RawMessage(tgMessage, telegramApi, botToken), tgMessage.document)
            }

            return null
        }
    }

}
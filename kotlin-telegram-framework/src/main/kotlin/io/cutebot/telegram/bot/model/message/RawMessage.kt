package io.cutebot.telegram.bot.model.message

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.TgChat
import io.cutebot.telegram.client.model.TgDocument
import io.cutebot.telegram.client.model.TgMessage
import io.cutebot.telegram.client.model.TgUser
import io.cutebot.telegram.client.model.TgVideo
import io.cutebot.telegram.client.model.photo.TgPhotoSize

class RawMessage(
        tgMessage: TgMessage,
        internal val telegramApi: TelegramApi,
        internal val botToken: String
) {
    val messageId: Long = tgMessage.messageId
    val from: TgUser? = tgMessage.from
    val chat: TgChat = tgMessage.chat
    val date: Long = tgMessage.date
    val forwardFrom: TgUser? = tgMessage.forwardFrom
    val forwardFromChat: TgChat? = tgMessage.forwardFromChat
    val forwardFromMessageId: Long? = tgMessage.forwardFromMessageId
    val forwardSignature: String? = tgMessage.forwardSignature
    val forwardDate: Long? = tgMessage.forwardDate
    val forwardSenderName: String? = tgMessage.forwardSenderName
    val viaBot: TgUser? = tgMessage.viaBot
    val replyToMessage: TgMessage? = tgMessage.replyToMessage
    val editDate: Long? = tgMessage.editDate
    val mediaGroupId: String? = tgMessage.mediaGroupId
    val authorSignature: String? = tgMessage.authorSignature
    val text: String? = tgMessage.text
    val caption: String? = tgMessage.caption
    val photo: List<TgPhotoSize>? = tgMessage.photo
    val document: TgDocument? = tgMessage.document
    val video: TgVideo? = tgMessage.video
}
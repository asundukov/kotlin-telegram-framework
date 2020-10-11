package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty


class TgForwardMessage(
    chatId: Long,

    @field: JsonProperty("from_chat_id")
    val fromChatId: Long,

    @field: JsonProperty("message_id")
    val messageId: Long

): TgSendMessage(chatId)

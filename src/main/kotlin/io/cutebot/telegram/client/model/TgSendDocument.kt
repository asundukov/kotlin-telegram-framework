package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.cutebot.telegram.client.model.keyboard.TgKeyboard
import java.io.File

class TgSendDocument(
        chatId: Long,

        @field:JsonProperty("document")
        val document: File,

        @field:JsonProperty("caption")
        val caption: String? = null,

        @field:JsonProperty("reply_markup")
        val replyMarkup: TgKeyboard? = null,

        @field: JsonProperty("parse_mode")
        val parseMode: String = "HTML"

): TgSendMessage(chatId)

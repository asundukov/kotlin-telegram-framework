package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.File

class TgSendDocument(
        chatId: Long,

        @field:JsonProperty("document")
        val document: File,

        @field:JsonProperty("caption")
        val caption: String? = null

): TgSendMessage(chatId)

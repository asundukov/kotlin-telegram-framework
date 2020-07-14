package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.File

class TgSendPhoto(
        chatId: Long,

        @field:JsonProperty("photo")
        val photo: File,

        @field:JsonProperty("caption")
        val caption: String? = null

) : TgSendMessage(chatId)

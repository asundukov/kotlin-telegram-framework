package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty

open class TgSendMessage(
        @field: JsonProperty("chat_id")
        val chatId: Long
)

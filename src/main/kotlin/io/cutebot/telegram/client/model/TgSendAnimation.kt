package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty

class TgSendAnimation(
        chatId: Long,

        @field:JsonProperty("caption")
        private val caption: String,

        @field:JsonProperty("animation")
        private val animation: String,

        @field:JsonProperty("parse_mode")
        private val parseMode: String
) : TgSendMessage(chatId)
package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty

data class TgCallbackQuery (
        @field: JsonProperty
        val id: String,

        @field: JsonProperty
        val from: TgUser,

        @field: JsonProperty
        val message: TgMessage,

        @field: JsonProperty("inline_message_id")
        val inlineMessageId: String?,

        @field: JsonProperty("chat_instance")
        var chatInstance: String?,

        @field: JsonProperty
        var data: String?

)

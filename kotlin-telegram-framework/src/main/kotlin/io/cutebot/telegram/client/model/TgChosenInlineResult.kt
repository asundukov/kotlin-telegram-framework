package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty

data class TgChosenInlineResult(

        @field: JsonProperty("result_id")
        val resultId: String?,

        @field: JsonProperty
        val from: TgUser?,

        @field: JsonProperty("inline_message_id")
        var inlineMessageId: String?,

        @field: JsonProperty
        var query: String?
)

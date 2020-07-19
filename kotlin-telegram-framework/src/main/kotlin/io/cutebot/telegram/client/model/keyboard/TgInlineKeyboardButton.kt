package io.cutebot.telegram.client.model.keyboard

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class TgInlineKeyboardButton (
        @field: JsonProperty
        val text: String,

        @field: JsonProperty
        val url: String? = null,

        @field: JsonProperty("callback_data")
        val callbackData: String? = null,

        @field: JsonProperty("switch_inline_query")
        val switchInlineQuery: String? = null
)

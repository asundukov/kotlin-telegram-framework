package io.cutebot.telegram.client.model.inline

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.cutebot.telegram.client.model.keyboard.TgInlineKeyboardMarkup

@JsonInclude(JsonInclude.Include.NON_NULL)
class TgInlineQueryResultDocument (
        @field: JsonProperty
        val id: String,

        @field: JsonProperty
        val title: String,

        @field: JsonProperty
        val caption: String? = null,

        @field: JsonProperty("document_url")
        val documentUrl: String,

        @field: JsonProperty("thumb_url")
        val thumbUrl: String,

        @field: JsonProperty("mime_type")
        val mimeType: String,

        @field: JsonProperty
        val description: String? = null,

        @field: JsonProperty("input_message_content")
        val inputMessageContent: TgInputMessageContent? = null,

        @field: JsonProperty("reply_markup")
        val replyKeyboardMarkup: TgInlineKeyboardMarkup? = null

) : TgInlineQueryResult() {
        @field: JsonProperty
        val type: String = "document"
}

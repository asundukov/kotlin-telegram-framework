package io.cutebot.telegram.client.model.inline

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.cutebot.telegram.client.model.keyboard.TgInlineKeyboardMarkup
import org.apache.commons.codec.digest.DigestUtils.md5Hex

@JsonInclude(JsonInclude.Include.NON_NULL)
class TgInlineQueryResultArticle(
        @field: JsonProperty
        val id: String,

        @field: JsonProperty
        val title: String,

        @field: JsonProperty("input_message_content")
        val inputMessageContent: TgInputMessageContent,

        @field: JsonProperty
        val description: String? = null,


        @field: JsonProperty("reply_markup")
        val replyKeyboardMarkup: TgInlineKeyboardMarkup? = null

) : TgInlineQueryResult() {

    @field: JsonProperty
    val type: String = "article"

    companion object {
        fun text(message: String): TgInlineQueryResult {
            return TgInlineQueryResultArticle(
                    md5Hex(message),
                    message,
                    TgInputMessageContent(message)
            )
        }
    }

}

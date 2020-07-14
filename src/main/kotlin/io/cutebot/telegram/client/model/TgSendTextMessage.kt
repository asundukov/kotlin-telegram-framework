package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.cutebot.telegram.client.model.keyboard.TgKeyboard

@JsonInclude(JsonInclude.Include.NON_NULL)
class TgSendTextMessage(
        chatId: Long,

        @field: JsonProperty
        var text: String?,

        @field: JsonProperty("parse_mode")
        var parseMode: String = "HTML",

        @field: JsonProperty("disable_web_page_preview")
        var disableWebPagePreview: Boolean = true,

        @field: JsonProperty("disable_notification")
        var disableNotification: Boolean = true,

        @field: JsonProperty("reply_to_message_id")
        var replyToMessageId: Long? = null,

        @field: JsonProperty("reply_markup")
        var replyMarkup: TgKeyboard? = null,

        @field: JsonProperty("message_id")
        var messageId: Long? = null,

        @field: JsonProperty("inline_message_id")
        var inlineMessageId: String? = null

) : TgSendMessage(chatId) {

    override fun toString(): String {
        return "TgSendTextMessage{" +
                "text='" + text + '\'' +
                ", parseMode='" + parseMode + '\'' +
                ", disableWebPagePreview=" + disableWebPagePreview +
                ", disableNotification=" + disableNotification +
                ", replyToMessageId=" + replyToMessageId +
                ", replyMarkup=" + replyMarkup +
                ", messageId=" + messageId +
                ", inlineMessageId='" + inlineMessageId + '\'' +
                '}'
    }
}
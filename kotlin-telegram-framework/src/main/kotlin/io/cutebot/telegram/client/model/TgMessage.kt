package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.cutebot.telegram.client.model.photo.TgPhotoSize

@JsonIgnoreProperties(ignoreUnknown = true)
data class TgMessage (
        @field: JsonProperty("message_id")
        val messageId: Long,

        @field: JsonProperty
        val from: TgUser?,

        @field: JsonProperty
        val chat: TgChat,

        @field: JsonProperty
        val date: Long,

        @field: JsonProperty("forward_from")
        val forwardFrom: TgUser?,

        @field: JsonProperty("forward_from_chat")
        val forwardFromChat: TgChat?,

        @field: JsonProperty("forward_from_message_id")
        val forwardFromMessageId: Long?,

        @field: JsonProperty("forward_signature")
        val forwardSignature: String?,

        @field: JsonProperty("forward_date")
        val forwardDate: Long?,

        @field: JsonProperty("forward_sender_name")
        val forwardSenderName: String?,

        @field: JsonProperty("via_bot")
        val viaBot: TgUser?,

        @field: JsonProperty("reply_to_message")
        val replyToMessage: TgMessage?,

        @field: JsonProperty("edit_date")
        val editDate: Long?,

        @field: JsonProperty("media_group_id")
        val mediaGroupId: String?,

        @field: JsonProperty("author_signature")
        val authorSignature: String?,

        @field: JsonProperty("text")
        val text: String?,

        @field: JsonProperty("caption")
        val caption: String?,

        @field: JsonProperty("photo")
        val photo: List<TgPhotoSize>?,

        @field: JsonProperty("document")
        val document: TgDocument?

)

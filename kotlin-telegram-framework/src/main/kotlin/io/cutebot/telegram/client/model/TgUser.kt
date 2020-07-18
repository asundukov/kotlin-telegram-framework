package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class TgUser (
        @field: JsonProperty
        val id: Long,

        @field: JsonProperty("is_bot")
        val isBot: Boolean,

        @field: JsonProperty("first_name")
        val firstName: String,

        @field: JsonProperty("last_name")
        val lastName: String?,

        @field: JsonProperty("username")
        val userName: String?,

        @field: JsonProperty("language_code")
        val languageCode: String?,

        @field: JsonProperty("supports_inline_queries")
        val supportsInlineQueries: Boolean?
)

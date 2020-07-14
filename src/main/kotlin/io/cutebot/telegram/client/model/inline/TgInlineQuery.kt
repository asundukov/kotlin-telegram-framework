package io.cutebot.telegram.client.model.inline

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.cutebot.telegram.client.model.TgUser


@JsonIgnoreProperties(ignoreUnknown = true)
data class TgInlineQuery (
        @field: JsonProperty
        val id: String,
        @field: JsonProperty
        val from: TgUser,
        @field: JsonProperty
        val query: String,
        @field: JsonProperty
        val offset: String
)

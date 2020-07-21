package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty

data class TgBotCommand(

        @field: JsonProperty
        val command: String,

        @field: JsonProperty
        val description: String
)

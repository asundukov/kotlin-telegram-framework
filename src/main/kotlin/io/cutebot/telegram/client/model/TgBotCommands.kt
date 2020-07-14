package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty

data class TgBotCommands (
        @field: JsonProperty
        val commands: ArrayList<TgBotCommand>
)

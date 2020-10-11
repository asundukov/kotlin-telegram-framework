package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty

class TgLocation(
        @field: JsonProperty
        val longitude: Double,
        @field: JsonProperty
        val latitude: Double
)

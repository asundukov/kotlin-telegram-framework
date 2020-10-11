package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty

class TgVenue(
        @field: JsonProperty
        val location: TgLocation,

        @field: JsonProperty
        val title: String,

        @field: JsonProperty
        val address: String,

        @field: JsonProperty
        val foursquareId: String? = null,

        @field: JsonProperty
        val foursquareType: String? = null
)

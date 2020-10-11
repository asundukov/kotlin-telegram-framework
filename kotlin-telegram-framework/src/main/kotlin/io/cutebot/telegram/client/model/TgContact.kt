package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty

class TgContact(
        @field: JsonProperty("phone_number")
        val phoneNumber: String,

        @field: JsonProperty("first_name")
        val firstName: String,

        @field: JsonProperty("last_name")
        val lastName: String? = null,

        @field: JsonProperty("user_id")
        val userId: Long? = null,

        @field: JsonProperty("vcard")
        val vcard: String? = null

)

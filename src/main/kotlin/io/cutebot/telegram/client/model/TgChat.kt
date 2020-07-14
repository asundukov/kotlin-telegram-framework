package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.cutebot.telegram.client.model.photo.TgPhoto

@JsonIgnoreProperties(ignoreUnknown = true)
data class TgChat(
        @field: JsonProperty
        val id: Long,

        @field: JsonProperty
        val type: String,

        @field: JsonProperty
        val title: String?,

        @field: JsonProperty("username")
        val userName: String?,

        @field: JsonProperty("first_name")
        val firstName: String?,

        @field: JsonProperty("last_name")
        val lastName: String?,

        @field: JsonProperty("all_members_are_administrators")
        val allMembersAreAdministrators: Boolean?,

        @field: JsonProperty("photo")
        val photo: TgPhoto?

)

package io.cutebot.telegram.client.model.photo

import com.fasterxml.jackson.annotation.JsonProperty

data class TgPhoto(

        @field: JsonProperty("small_file_id")
        val smallFileId: String?,

        @field: JsonProperty("small_file_unique_id")
        val smallFileUniqueId: String?,

        @field: JsonProperty("big_file_id")
        val bigFileId: String?,

        @field: JsonProperty("big_file_unique_id")
        val bigFileUniqueId: String?
)

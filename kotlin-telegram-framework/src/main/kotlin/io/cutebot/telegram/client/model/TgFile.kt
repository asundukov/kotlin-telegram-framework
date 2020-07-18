package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty

abstract class TgFile(
        @field: JsonProperty("file_id")
        val fileId: String,

        @field: JsonProperty("file_unique_id")
        val fileUniqueId: String
)

package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty

data class TgFile(
        @field: JsonProperty("file_id")
        val fileId: String,

        @field: JsonProperty("file_unique_id")
        val fileUniqueId: String,

        @field: JsonProperty("file_size")
        val fileSize: Int? = null,

        @field: JsonProperty("file_path")
        val filePath: String
)

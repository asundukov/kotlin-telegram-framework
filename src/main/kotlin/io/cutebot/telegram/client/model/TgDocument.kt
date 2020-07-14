package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class TgDocument (
        @field: JsonProperty("file_id")
        val fileId: String,

        @field: JsonProperty("file_unique_id")
        val fileUniqueId: String,

        @field: JsonProperty("file_size")
        val fileSize: Int,

        @field: JsonProperty("file_name")
        val fileName: String,

        @field: JsonProperty("mime_type")
        val mimeType: String

)

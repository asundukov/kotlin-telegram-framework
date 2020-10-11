package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty

open class TgVoice (
        @field: JsonProperty("file_size")
        val fileSize: Int?,

        @field: JsonProperty("mime_type")
        val mimeType: String?,

        @field: JsonProperty
        val duration: Int,

        fileId: String,

        fileUniqueId: String

): TgFile(fileId, fileUniqueId)

package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.cutebot.telegram.client.model.photo.TgPhotoSize

class TgVideo (
        @field: JsonProperty("file_size")
        val fileSize: Int?,

        @field: JsonProperty("mime_type")
        val mimeType: String?,

        @field: JsonProperty
        val thumb: TgPhotoSize?,

        @field: JsonProperty
        val width: Int,

        @field: JsonProperty
        val height: Int,

        @field: JsonProperty
        val duration: Int,

        fileId: String,

        fileUniqueId: String

): TgFile(fileId, fileUniqueId)


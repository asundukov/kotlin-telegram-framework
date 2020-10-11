package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.cutebot.telegram.client.model.photo.TgPhotoSize

class TgVideoNote (
        @field: JsonProperty("file_size")
        val fileSize: Int?,

        @field: JsonProperty
        val thumb: TgPhotoSize?,

        @field: JsonProperty
        val length: Int,

        @field: JsonProperty
        val duration: Int,

        fileId: String,

        fileUniqueId: String

): TgFile(fileId, fileUniqueId)

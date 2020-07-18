package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.cutebot.telegram.client.model.photo.TgPhotoSize

@JsonIgnoreProperties(ignoreUnknown = true)
class TgDocument (
        @field: JsonProperty("file_size")
        val fileSize: Int?,

        @field: JsonProperty("file_name")
        val fileName: String?,

        @field: JsonProperty("mime_type")
        val mimeType: String?,

        @field: JsonProperty
        val thumb: TgPhotoSize?,

        fileId: String,

        fileUniqueId: String

): TgFile(fileId, fileUniqueId)

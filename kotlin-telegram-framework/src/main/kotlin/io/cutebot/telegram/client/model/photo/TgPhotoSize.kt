package io.cutebot.telegram.client.model.photo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.cutebot.telegram.client.model.TgFile

@JsonIgnoreProperties(ignoreUnknown = true)
class TgPhotoSize (

        @field: JsonProperty
        val width: Int,

        @field: JsonProperty
        val height: Int,

        @field: JsonProperty("file_size")
        val fileSize: Long?,

        fileId: String,

        fileUniqueId: String

): TgFile(fileId, fileUniqueId)

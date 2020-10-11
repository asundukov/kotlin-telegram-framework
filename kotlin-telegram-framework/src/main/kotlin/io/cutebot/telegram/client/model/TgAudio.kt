package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.cutebot.telegram.client.model.photo.TgPhotoSize

@JsonIgnoreProperties(ignoreUnknown = true)
class TgAudio (
        @field: JsonProperty("title")
        val title: String?,

        @field: JsonProperty("performer")
        val performer: String?,

        @field: JsonProperty
        val thumb: TgPhotoSize?,

        fileSize: Int?,

        mimeType: String?,

        duration: Int,

        fileId: String,

        fileUniqueId: String

): TgVoice(fileSize, mimeType, duration, fileId, fileUniqueId)

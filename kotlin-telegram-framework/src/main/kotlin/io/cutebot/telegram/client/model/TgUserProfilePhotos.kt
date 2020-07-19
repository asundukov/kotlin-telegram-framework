package io.cutebot.telegram.client.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.cutebot.telegram.client.model.photo.TgPhotoSize

data class TgUserProfilePhotos (
        @field:JsonProperty(value = "total_count")
        val totalCount: Int,

        val photos: List<List<TgPhotoSize>>
)

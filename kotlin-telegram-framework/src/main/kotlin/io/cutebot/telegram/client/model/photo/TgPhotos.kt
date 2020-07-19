package io.cutebot.telegram.client.model.photo

import com.fasterxml.jackson.annotation.JsonProperty

data class TgPhotos (
    @field: JsonProperty("total_count")
    val totalCount: Long?,

    @field: JsonProperty
    val photos: List<TgPhotoList>?

)

package io.cutebot.telegram.client.model.photo

import com.fasterxml.jackson.annotation.JsonProperty

class TgPhotoInfo(

        @field: JsonProperty("file_id")
        val fileId: String,

        @field: JsonProperty("file_size")
        val fileSize: Long?,

        @field: JsonProperty
        val width: Long?,

        @field: JsonProperty
        val height: Long?

) : Comparable<TgPhotoInfo> {

    override fun compareTo(other: TgPhotoInfo): Int {
        return width!!.compareTo(other.width!!)
    }
}
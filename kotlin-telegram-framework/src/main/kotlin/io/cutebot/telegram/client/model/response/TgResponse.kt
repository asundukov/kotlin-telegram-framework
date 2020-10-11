package io.cutebot.telegram.client.model.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
open class TgResponse<T> {

    @field: JsonProperty
    val ok: Boolean? = null

    @field: JsonProperty
    val result: T? = null

    @field: JsonProperty
    val description: String? = null


    override fun toString(): String {
        return "TgResponse{" +
                "ok=" + ok +
                ", result=" + result +
                '}'
    }
}
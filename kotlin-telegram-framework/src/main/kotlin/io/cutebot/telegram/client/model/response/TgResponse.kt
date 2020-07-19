package io.cutebot.telegram.client.model.response

import com.fasterxml.jackson.annotation.JsonProperty

open class TgResponse<T> {

    @field: JsonProperty
    var ok: Boolean? = null

    @field: JsonProperty
    var result: T? = null


    override fun toString(): String {
        return "TgResponse{" +
                "ok=" + ok +
                ", result=" + result +
                '}'
    }
}
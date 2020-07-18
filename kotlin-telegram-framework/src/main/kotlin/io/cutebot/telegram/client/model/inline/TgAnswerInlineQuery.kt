package io.cutebot.telegram.client.model.inline

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.ArrayList

@JsonInclude(JsonInclude.Include.NON_NULL)
data class TgAnswerInlineQuery (
        @field: JsonProperty("inline_query_id")
        val inlineQueryId: String,

        @field: JsonProperty
        val results: ArrayList<TgInlineQueryResult> = ArrayList(),

        @field: JsonProperty("cache_time")
        val cacheTime: Int = 10,

        @field: JsonProperty("is_personal")
        val isPersonal: Boolean? = null,

        @JsonProperty("next_offset")
        val nextOffset: String = "",

        @JsonProperty("switch_pm_text")
        val switchPmText: String? = null,

        @JsonProperty("switch_pm_parameter")
        val switchPmParameter: String? = null
)

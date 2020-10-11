package io.cutebot.telegram.client.model.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.cutebot.telegram.client.model.TgMessage

@JsonIgnoreProperties(ignoreUnknown = true)
class TgResponseMessage : TgResponse<TgMessage?>()

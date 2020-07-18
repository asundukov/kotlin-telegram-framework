package io.cutebot.telegram.client.model.keyboard

import com.fasterxml.jackson.annotation.JsonProperty

class TgReplyKeyboardMarkup (
        @field: JsonProperty
        val keyboard: List<List<TgKeyboardButton>>,

        @field: JsonProperty("resize_keyboard")
        val resizeKeyboard: Boolean = true,

        @field: JsonProperty("one_time_keyboard")
        val oneTimeKeyboard: Boolean = true,

        @field: JsonProperty("selective")
        val selective: Boolean = false
): TgKeyboard()

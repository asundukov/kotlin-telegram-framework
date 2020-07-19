package io.cutebot.telegram.client.model.keyboard

import com.fasterxml.jackson.annotation.JsonProperty

class TgKeyboardRemove: TgKeyboard() {
    @field: JsonProperty("remove_keyboard")
    val removeKeyboard: Boolean = true
}

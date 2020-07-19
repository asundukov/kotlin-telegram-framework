package io.cutebot.telegram.bot.model

import io.cutebot.telegram.client.model.TgChat

class Chat private constructor() {
    companion object {
        fun create(tgChat: TgChat): Chat {
            return Chat()
        }
        fun createNullable(tgChat: TgChat?): Chat? {
            tgChat ?: return null
            return create(tgChat)
        }
    }
}
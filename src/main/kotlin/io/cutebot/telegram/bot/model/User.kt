package io.cutebot.telegram.bot.model

import io.cutebot.telegram.client.model.TgUser

class User private constructor(tgUser: TgUser) {

    val id = tgUser.id

    companion object {
        fun create(tgUser: TgUser?): User? {
            tgUser ?: return null
            return User(tgUser)
        }
    }
}
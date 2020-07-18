package io.cutebot.telegram.samples.photo


import io.cutebot.telegram.bot.StatefulBot
import io.cutebot.telegram.bot.block.BotBlock

class PhotoBot(
        private val token: String,
        defaultBlock: BotBlock
): StatefulBot(defaultBlock) {

    override fun getToken(): String {
        return token
    }

}

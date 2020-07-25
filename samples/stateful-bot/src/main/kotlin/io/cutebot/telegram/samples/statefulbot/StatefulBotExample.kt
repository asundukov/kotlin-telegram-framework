package io.cutebot.telegram.samples.statefulbot

import io.cutebot.telegram.bot.StatefulBot
import io.cutebot.telegram.bot.block.BotBlock

class StatefulBotExample(
        private val token: String,
        currentBlock: BotBlock
): StatefulBot(currentBlock) {
    override fun getToken(): String {
        return token
    }
}

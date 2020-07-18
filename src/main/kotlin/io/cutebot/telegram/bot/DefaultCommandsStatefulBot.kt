package io.cutebot.telegram.bot

import io.cutebot.telegram.bot.block.BotBlock
import io.cutebot.telegram.bot.command.Command

class DefaultCommandsStatefulBot(
        private val token: String,
        currentBlock: BotBlock,
        commands: List<Command>
): CommandsStatefulBot(currentBlock, commands) {

    override fun getToken(): String {
        return token
    }

}

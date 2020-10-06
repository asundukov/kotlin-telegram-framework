package io.cutebot.telegram.bot.command

import io.cutebot.telegram.bot.block.BotBlock
import io.cutebot.telegram.bot.model.message.RawMessage

class RedirectCommand(
        private val botBlock: BotBlock,
        private val command: String,
        private val isSystemCommand: Boolean = false,
        private val commandDescription: String = ""
): Command {
    override fun handleCommand(query: String, message: RawMessage): BotBlock {
        return botBlock
    }

    override fun getCommand(): String {
        return command
    }

    override fun getCommandDescription(): String {
        return commandDescription
    }

    override fun isSystemCommand(): Boolean {
        return isSystemCommand
    }
}

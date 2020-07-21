package io.cutebot.telegram.bot.command

import io.cutebot.telegram.bot.block.BotBlock
import io.cutebot.telegram.bot.model.RawMessage

interface Command {
    /**
     * Handle user's message requests to bot
     */
    fun handleCommand(query: String, message: RawMessage): BotBlock

    /**
     * Command to immediately call this block of bot.
     * It sets to system menu in telegram on bot's startup if isSystemCommand returns true
     */
    fun getCommand(): String

    /**
     * Command description to show in telegram's bot's menu
     */
    fun getCommandDescription(): String

    /**
     * Set it to true if this command need to be shown at bot's system menu
     */
    fun isSystemCommand(): Boolean
}

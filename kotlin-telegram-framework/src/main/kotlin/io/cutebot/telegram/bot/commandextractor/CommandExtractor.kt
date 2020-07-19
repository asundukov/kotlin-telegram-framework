package io.cutebot.telegram.bot.commandextractor

interface CommandExtractor {
    fun isCommand(text: String): Boolean
    fun extractCommand(text: String): CommandWithParams
}
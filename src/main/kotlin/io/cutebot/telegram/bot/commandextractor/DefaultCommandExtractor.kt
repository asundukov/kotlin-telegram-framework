package io.cutebot.telegram.bot.commandextractor

import kotlin.math.min

/**
 * Default behavior for command extracting.
 * Commands begin only on "/" symbol
 * Cannot use "_" in commands names, but it used to separate commands and queries
 */
class DefaultCommandExtractor: CommandExtractor {
    override fun isCommand(text: String): Boolean {
        return text.length > 1 && text[0] == '/'
    }

    override fun extractCommand(text: String): CommandWithParams {
        var spaceIndex = text.indexOf(" ")
        var underscopeIndex = text.indexOf("_")

        if (spaceIndex == -1) {
            spaceIndex = text.length
        }

        if (underscopeIndex == -1) {
            underscopeIndex = text.length
        }

        val minIndex = min(spaceIndex, underscopeIndex)

        val command = text.subSequence(0, minIndex).toString()
        var params = text.subSequence(minIndex, text.length).toString().trim()

        if (params.isNotEmpty() && params[0] == '_') {
            params = params.substring(1, params.length)
        }

        return CommandWithParams(command, params)
    }

}
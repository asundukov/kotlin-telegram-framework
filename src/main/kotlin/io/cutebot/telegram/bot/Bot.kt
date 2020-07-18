package io.cutebot.telegram.bot

import io.cutebot.telegram.BotHandler
import io.cutebot.telegram.client.model.TgBotCommands
import io.cutebot.telegram.client.model.inline.TgAnswerInlineQuery
import io.cutebot.telegram.client.model.inline.TgInlineQuery

interface Bot: BotHandler {
    fun getToken(): String

    fun handleInlineQuery(inlineQuery: TgInlineQuery): TgAnswerInlineQuery {
        return TgAnswerInlineQuery("")
    }

    /**
     * Commands to setup bot's system menu on startup.
     * Pass null to not change it
     */
    fun getCommands(): TgBotCommands? {
        return TgBotCommands(emptyList())
    }

}

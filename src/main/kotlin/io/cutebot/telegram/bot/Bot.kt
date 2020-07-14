package io.cutebot.telegram.bot

import io.cutebot.telegram.BotHandler
import io.cutebot.telegram.client.model.TgCallbackQuery
import io.cutebot.telegram.client.model.TgSendMessageUpdate
import io.cutebot.telegram.client.model.inline.TgAnswerInlineQuery
import io.cutebot.telegram.client.model.inline.TgInlineQuery

abstract class Bot: BotHandler {
    abstract fun getToken(): String

    fun handleInlineQuery(inlineQuery: TgInlineQuery): TgAnswerInlineQuery {
        return TgAnswerInlineQuery("")
    }

    fun handleCallbackQuery(callbackQuery: TgCallbackQuery): TgSendMessageUpdate {
        TODO()
    }

}
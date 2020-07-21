package io.cutebot.telegram.bot

import io.cutebot.telegram.bot.model.RawMessage
import io.cutebot.telegram.client.model.TgBotCommands
import io.cutebot.telegram.client.model.inline.TgAnswerInlineQuery
import io.cutebot.telegram.client.model.inline.TgInlineQuery
import io.cutebot.telegram.interaction.model.ChatAnswer

interface Bot {

    fun getToken(): String

    fun handleInlineQuery(inlineQuery: TgInlineQuery): TgAnswerInlineQuery = TgAnswerInlineQuery(inlineQuery.id)

    fun handleMessage(message: RawMessage): ChatAnswer = ChatAnswer.noAnswer()

    fun getCommands(): TgBotCommands? = null
}

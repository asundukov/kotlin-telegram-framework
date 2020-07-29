package io.cutebot.telegram.bot

import io.cutebot.telegram.bot.model.RawMessage
import io.cutebot.telegram.client.model.TgBotCommands
import io.cutebot.telegram.client.model.TgChosenInlineResult
import io.cutebot.telegram.client.model.inline.TgAnswerInlineQuery
import io.cutebot.telegram.client.model.inline.TgInlineQuery
import io.cutebot.telegram.interaction.model.ChatAnswer

interface Bot {

    fun getToken(): String

    //Don't forget send /setinline to @BotFather to enable this feature
    fun handleInlineQuery(inlineQuery: TgInlineQuery): TgAnswerInlineQuery = TgAnswerInlineQuery(inlineQuery.id)

    //Don't forget send /setinlinefeedback to @BotFather to enable this feature
    fun handleChosenInlineQuery(chosenInlineResult: TgChosenInlineResult) = Unit

    fun handleMessage(message: RawMessage): ChatAnswer = ChatAnswer.noAnswer()

    fun getCommands(): TgBotCommands? = null

}

package io.cutebot.telegram.samples.inline


import io.cutebot.telegram.bot.Bot
import io.cutebot.telegram.bot.model.RawMessage
import io.cutebot.telegram.client.model.inline.TgAnswerInlineQuery
import io.cutebot.telegram.client.model.inline.TgInlineQuery
import io.cutebot.telegram.client.model.inline.TgInlineQueryResultArticle
import io.cutebot.telegram.interaction.model.ChatAnswer

class InlineBot(
        private val token: String
): Bot {

    override fun getToken(): String {
        return token
    }

    override fun handleMessage(message: RawMessage): ChatAnswer {
        return ChatAnswer.inlineQueryInvitationChatSelection("Hi. Click here to try.", "try it!", "your query")
    }

    override fun handleInlineQuery(inlineQuery: TgInlineQuery): TgAnswerInlineQuery {
        val result = TgAnswerInlineQuery(inlineQuery.id)
        val item = TgInlineQueryResultArticle.text("Your request: " + inlineQuery.query)
        result.results.add(item)
        return result
    }
}

package io.cutebot.telegram.samples.inline


import io.cutebot.telegram.bot.Bot
import io.cutebot.telegram.client.model.inline.TgAnswerInlineQuery
import io.cutebot.telegram.client.model.inline.TgInlineQuery
import io.cutebot.telegram.client.model.inline.TgInlineQueryResult
import io.cutebot.telegram.client.model.inline.TgInlineQueryResultArticle

class InlineBot(
        private val token: String
): Bot {

    override fun getToken(): String {
        return token
    }

    override fun handleInlineQuery(inlineQuery: TgInlineQuery): TgAnswerInlineQuery {
        val result = TgAnswerInlineQuery(inlineQuery.id)
        val item = TgInlineQueryResultArticle.text("Your request: " + inlineQuery.query)
        result.results.add(item)
        return result
    }
}

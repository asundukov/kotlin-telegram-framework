package io.cutebot.telegram.samples.inline


import io.cutebot.telegram.bot.Bot
import io.cutebot.telegram.bot.model.message.RawMessage
import io.cutebot.telegram.client.model.TgChosenInlineResult
import io.cutebot.telegram.client.model.inline.TgAnswerInlineQuery
import io.cutebot.telegram.client.model.inline.TgInlineQuery
import io.cutebot.telegram.client.model.inline.TgInlineQueryResultArticle
import io.cutebot.telegram.interaction.model.ChatAnswer
import org.apache.commons.codec.digest.DigestUtils

class InlineBot(
        private val token: String
): Bot {

    override fun getToken(): String {
        return token
    }

    override fun handleMessage(message: RawMessage): ChatAnswer {
        return ChatAnswer.inlineQueryInvitationChatSelection("Hi. Click here to try.", "try it!", "your query")
    }

    //Don't forget send /setinline to @BotFather to enable this feature
    override fun handleInlineQuery(inlineQuery: TgInlineQuery): TgAnswerInlineQuery {
        val result = TgAnswerInlineQuery(inlineQuery.id)
        val item = TgInlineQueryResultArticle.text("Your request: " + inlineQuery.query)
        val item2 = TgInlineQueryResultArticle.text("Second result " + DigestUtils.md5Hex(inlineQuery.id))
        result.results.add(item)
        result.results.add(item2)
        return result
    }

    //Don't forget send /setinlinefeedback to @BotFather to enable this feature
    override fun handleChosenInlineQuery(chosenInlineResult: TgChosenInlineResult) {
        println("Chosen variant: " + chosenInlineResult.query)
    }
}

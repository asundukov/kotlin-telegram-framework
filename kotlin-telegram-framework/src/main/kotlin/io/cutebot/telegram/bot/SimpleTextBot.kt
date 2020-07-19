package io.cutebot.telegram.bot

import io.cutebot.telegram.bot.model.RawMessage
import io.cutebot.telegram.client.model.TgChat
import io.cutebot.telegram.client.model.TgUser
import io.cutebot.telegram.interaction.model.ChatAnswer

abstract class SimpleTextBot: Bot {

    abstract fun handleText(text: String, from: TgUser, chat: TgChat): String

    override fun handleMessage(message: RawMessage): ChatAnswer {
        if (message.text != null && message.from != null) {
            val answerText = handleText(message.text, message.from, message.chat)
            return ChatAnswer.text(answerText)
        }

        return ChatAnswer.noAnswer()
    }
}

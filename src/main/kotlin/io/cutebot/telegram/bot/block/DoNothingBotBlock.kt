package io.cutebot.telegram.bot.block

import io.cutebot.telegram.bot.model.TextMessage
import io.cutebot.telegram.interaction.model.ChatAnswer

class DoNothingBotBlock: BotTextBlock {
    override fun getAnswer(): ChatAnswer {
        return ChatAnswer.noAnswer()
    }

    override fun handleText(message: TextMessage): BotBlock {
        return this
    }

    companion object {
        val DO_NOTHING_BOT_BLOCK = DoNothingBotBlock()
    }
}

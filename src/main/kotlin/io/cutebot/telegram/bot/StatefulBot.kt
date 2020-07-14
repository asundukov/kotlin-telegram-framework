package io.cutebot.telegram.bot

import io.cutebot.telegram.BotBlock
import io.cutebot.telegram.client.model.TgMessage
import io.cutebot.telegram.interaction.model.ChatAnswer

abstract class StatefulBot(
        private var currentBlock: BotBlock
): Bot() {

    override fun handleMessage(message: TgMessage): ChatAnswer {
        if (message.text != null) {
            currentBlock = currentBlock.handleText(message)
            return currentBlock.getMessage()
        }

        return ChatAnswer.noAnswer()
    }

}

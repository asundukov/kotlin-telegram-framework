package io.cutebot.telegram.bot

import io.cutebot.telegram.bot.block.BotBlock
import io.cutebot.telegram.bot.model.message.DocumentMessage
import io.cutebot.telegram.bot.model.message.PhotoMessage
import io.cutebot.telegram.bot.model.message.RawMessage
import io.cutebot.telegram.bot.model.message.TextMessage
import io.cutebot.telegram.bot.model.message.VideoMessage
import io.cutebot.telegram.bot.model.settings.ChatMessagesStrategy
import io.cutebot.telegram.interaction.model.ChatAnswer

abstract class StatefulBot(
        protected var currentBlock: BotBlock,
        private val botSettings: BotSettings = BotSettings()
): Bot {

    override fun handleMessage(message: RawMessage): ChatAnswer {
        return chatAnswer(message)
    }

    internal fun chatAnswer(message: RawMessage): ChatAnswer {
        if (botSettings.chatMessagesStrategy == ChatMessagesStrategy.IGNORE
                && message.from != null && message.from.id != message.chat.id) {
            return ChatAnswer.noAnswer()
        }

        if (message.text != null) {
            currentBlock = currentBlock.handleText(TextMessage(message, message.text))
            return currentBlock.getAnswer()
        }

        if (message.photo != null) {
            currentBlock = currentBlock.handlePhoto(PhotoMessage(message, message.photo))
            return currentBlock.getAnswer()
        }

        if (message.document != null) {
            currentBlock = currentBlock.handleDocument(DocumentMessage(message, message.document))
            return currentBlock.getAnswer()
        }

        if (message.video != null) {
            currentBlock = currentBlock.handleVideo(VideoMessage(message, message.video))
            return currentBlock.getAnswer()
        }

        return ChatAnswer.noAnswer()
    }

}

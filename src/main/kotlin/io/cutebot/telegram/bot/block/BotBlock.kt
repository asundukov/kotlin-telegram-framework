package io.cutebot.telegram.bot.block

import io.cutebot.telegram.bot.model.DocumentMessage
import io.cutebot.telegram.bot.model.PhotoMessage
import io.cutebot.telegram.bot.model.TextMessage
import io.cutebot.telegram.interaction.model.ChatAnswer

interface BotBlock {

    fun getAnswer(): ChatAnswer

    fun handleText(message: TextMessage): BotBlock
    fun handlePhoto(message: PhotoMessage): BotBlock
    fun handleDocument(message: DocumentMessage): BotBlock

}

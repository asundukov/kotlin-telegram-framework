package io.cutebot.telegram.bot.block

import io.cutebot.telegram.bot.model.message.DocumentMessage
import io.cutebot.telegram.bot.model.message.PhotoMessage
import io.cutebot.telegram.bot.model.message.TextMessage
import io.cutebot.telegram.bot.model.message.VideoMessage
import io.cutebot.telegram.interaction.model.ChatAnswer

interface BotBlock {

    fun getAnswer(): ChatAnswer

    fun handleText(message: TextMessage): BotBlock
    fun handlePhoto(message: PhotoMessage): BotBlock
    fun handleDocument(message: DocumentMessage): BotBlock
    fun handleVideo(message: VideoMessage): BotBlock

}

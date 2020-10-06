package io.cutebot.telegram.bot.block

import io.cutebot.telegram.bot.model.message.DocumentMessage
import io.cutebot.telegram.bot.model.message.PhotoMessage
import io.cutebot.telegram.bot.model.message.VideoMessage

interface BotTextBlock: BotBlock {
    override fun handlePhoto(message: PhotoMessage): BotBlock {
        return this
    }

    override fun handleDocument(message: DocumentMessage): BotBlock {
        return this
    }

    override fun handleVideo(message: VideoMessage): BotBlock {
        return this
    }
}
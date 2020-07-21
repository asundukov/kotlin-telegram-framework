package io.cutebot.telegram.bot.block

import io.cutebot.telegram.bot.model.DocumentMessage
import io.cutebot.telegram.bot.model.PhotoMessage

interface BotTextBlock: BotBlock {
    override fun handlePhoto(message: PhotoMessage): BotBlock {
        return this
    }

    override fun handleDocument(message: DocumentMessage): BotBlock {
        return this
    }
}
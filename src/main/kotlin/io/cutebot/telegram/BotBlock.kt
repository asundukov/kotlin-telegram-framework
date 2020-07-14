package io.cutebot.telegram

import io.cutebot.telegram.client.model.TgMessage
import io.cutebot.telegram.interaction.model.ChatAnswer

interface BotBlock: BotHandler {

    fun getMessage(): ChatAnswer

    fun handleText(message: TgMessage): BotBlock
    fun handlePhoto(): BotBlock
    fun handleDocument(): BotBlock

}
package io.cutebot.telegram.samples.statefulbot.block

import io.cutebot.telegram.bot.block.BotBlock
import io.cutebot.telegram.bot.block.BotTextBlock
import io.cutebot.telegram.bot.model.TextMessage
import io.cutebot.telegram.client.model.keyboard.builder.ReplyKeyboardSimpleBuilder
import io.cutebot.telegram.interaction.model.ChatAnswer
import io.cutebot.telegram.samples.statefulbot.Hero

class OfficeBlock(
        private val hero: Hero
): BotTextBlock {
    override fun getAnswer(): ChatAnswer {
        hero.money += 2
        hero.hp--

        val keyboard = ReplyKeyboardSimpleBuilder()
                .addRow(home, office)
                .build()

        val message = "You are at office \n" + hero.getStatus() + "Chose variant"

        return ChatAnswer.text(message, keyboard)
    }

    override fun handleText(message: TextMessage): BotBlock {
        if (message.text == home) {
            return HomeBlock(hero)
        }
        return this
    }

    companion object {
        private const val home = "Go home"
        private const val office = "Stay here"
    }

}

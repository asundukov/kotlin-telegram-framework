package io.cutebot.telegram.samples.statefulbot.block

import io.cutebot.telegram.bot.block.BotBlock
import io.cutebot.telegram.bot.block.BotTextBlock
import io.cutebot.telegram.bot.model.TextMessage
import io.cutebot.telegram.client.model.keyboard.builder.ReplyKeyboardSimpleBuilder
import io.cutebot.telegram.interaction.model.ChatAnswer
import io.cutebot.telegram.samples.statefulbot.Hero

class HomeBlock(
        private val hero: Hero
): BotTextBlock {
    override fun getAnswer(): ChatAnswer {
        hero.hp += 2
        if (hero.hp > 16) {
            hero.hp = 16
        }
        hero.money--

        val keyboard = ReplyKeyboardSimpleBuilder()
                .addRow(home, office)
                .build()

        val message = "You are at home \n" + hero.getStatus() + "Chose variant"

        return ChatAnswer.text(message, keyboard)
    }

    override fun handleText(message: TextMessage): BotBlock {
        if (message.text == office) {
            return OfficeBlock(hero)
        }
        return this
    }

    companion object {
        private const val home = "Stay here"
        private const val office = "Go Office"
    }

}

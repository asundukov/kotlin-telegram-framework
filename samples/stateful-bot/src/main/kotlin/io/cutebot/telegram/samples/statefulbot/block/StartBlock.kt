package io.cutebot.telegram.samples.statefulbot.block

import io.cutebot.telegram.bot.block.BotBlock
import io.cutebot.telegram.bot.block.BotTextBlock
import io.cutebot.telegram.bot.model.TextMessage
import io.cutebot.telegram.client.model.keyboard.builder.ReplyKeyboardSimpleBuilder
import io.cutebot.telegram.interaction.model.ChatAnswer
import io.cutebot.telegram.samples.statefulbot.Hero

class StartBlock(
        private val hero: Hero = Hero()
): BotTextBlock {
    override fun getAnswer(): ChatAnswer {
        hero.money--

        val keyboard = ReplyKeyboardSimpleBuilder()
                .addRow("Home", "Office")
                .build()

        return ChatAnswer.text(hero.getStatus() + "Chose variant", keyboard)
    }

    override fun handleText(message: TextMessage): BotBlock {
        val text = message.text
        if (text == home) {
            return HomeBlock(hero)
        }
        if (text == office) {
            return OfficeBlock(hero)
        }
        return this
    }

    companion object {
        private const val home = "Home"
        private const val office = "Office"
    }
}

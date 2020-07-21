package io.cutebot.telegram.samples.statefulbot

import io.cutebot.telegram.BotRunner
import io.cutebot.telegram.samples.statefulbot.block.StartBlock

class Application
fun main(args: Array<String>) {

    val botToken = args[0]

    val bot = StatefulBotExample(botToken, StartBlock())

    BotRunner().run(bot)
}

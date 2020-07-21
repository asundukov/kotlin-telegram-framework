package io.cutebot.telegram.samples.photo

import io.cutebot.telegram.BotRunner

class Application
fun main(args: Array<String>) {

    val botToken = args[0]

    val bot = PhotoBot(botToken, DefaultBlock())

    BotRunner().run(bot)
}

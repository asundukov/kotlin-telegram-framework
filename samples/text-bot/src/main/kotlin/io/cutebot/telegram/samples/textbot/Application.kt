package io.cutebot.telegram.samples.textbot

import io.cutebot.telegram.BotRunner

class Application
fun main(args: Array<String>) {

    val botToken = args[0]

    BotRunner()
            .run(TextBot(botToken))
}

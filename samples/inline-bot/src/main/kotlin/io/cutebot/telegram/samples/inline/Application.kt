package io.cutebot.telegram.samples.inline

import io.cutebot.telegram.BotRunner

class Application
fun main(args: Array<String>) {

    val botToken = args[0]

    val bot = InlineBot(botToken)

    BotRunner().run(bot)
}

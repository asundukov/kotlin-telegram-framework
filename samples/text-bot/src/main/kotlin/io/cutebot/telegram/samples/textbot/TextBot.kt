package io.cutebot.telegram.samples.textbot

import io.cutebot.telegram.bot.SimpleTextBot
import io.cutebot.telegram.client.model.TgChat
import io.cutebot.telegram.client.model.TgUser
import java.util.concurrent.atomic.AtomicInteger

class TextBot(
        private val token: String
): SimpleTextBot() {

    private val counter = AtomicInteger(0)

    override fun handleText(text: String, from: TgUser, chat: TgChat): String {
        return "hello!\n" +
                "this is message number " + counter.incrementAndGet().toString()
    }

    override fun getToken(): String {
        return token
    }
}

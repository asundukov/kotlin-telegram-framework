package io.cutebot.telegram

import io.cutebot.telegram.bot.Bot
import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.interaction.LongPollProcess
import org.slf4j.LoggerFactory
import java.util.concurrent.atomic.AtomicInteger

class BotRunner {
    private val api = TelegramApi()
    private val longPollTimeout = 55

    fun run(bot: Bot) {
        LongPollProcess(
                longPollTimeout = longPollTimeout,
                api = api,
                bot = bot
        ).start()
    }

    init {
        checkInstanceCount()
    }

    companion object {
        private val log = LoggerFactory.getLogger(BotRunner::class.java)
        private var instanceCount: AtomicInteger = AtomicInteger(0)

        fun checkInstanceCount() {
            if (instanceCount.incrementAndGet() > 1) {
                log.warn("More than 1 instance BotRunner created. Be careful of memory leak. Total: {}", instanceCount)
            }
        }
    }
}

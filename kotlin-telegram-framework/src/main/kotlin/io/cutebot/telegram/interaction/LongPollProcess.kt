package io.cutebot.telegram.interaction

import io.cutebot.telegram.bot.Bot
import io.cutebot.telegram.bot.model.RawMessage
import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.exception.BotGetUpdatesConflictException
import io.cutebot.telegram.exception.TgBotNotFoundException
import org.slf4j.LoggerFactory
import kotlin.reflect.full.declaredMemberFunctions

class LongPollProcess(
        private val longPollTimeout: Int,
        private val api: TelegramApi,
        private val bot: Bot
) : Thread() {

    private var ok = true
    override fun run() {
        var offset = 0
        var needSleep = 0L

        val botInfo = api.getMe(bot.getToken())
        val botUserName = "@" + botInfo.userName!!

        log.info("Running bot {}...", botUserName)

        val inlineHandlerExists = bot::class.declaredMemberFunctions
                .firstOrNull { it.name == "handleInlineQuery" } != null

        if (inlineHandlerExists && botInfo.supportsInlineQueries != true) {
            log.warn("Bot $botUserName doesn't support inline queries. Please check bot settings at @BotFather.")
        }

        bot.getCommands()?.let { api.setCommands(bot.getToken(), it) }

        while (ok && !this.isInterrupted) {
            try {
                val tgResponseUpdate = api.getUpdates(bot.getToken(), offset, longPollTimeout, 50)
                for (update in tgResponseUpdate.result) {
                    offset = update.updateId + 1
                    when {
                        update.message != null -> {
                            val result = bot.handleMessage(RawMessage(update.message, api, bot.getToken()))
                            result.fireAction(
                                    api = api,
                                    token = bot.getToken(),
                                    chatId = update.message.chat.id
                            )
                        }
                        update.inlineQuery != null -> {
                            val result = bot.handleInlineQuery(update.inlineQuery)
                            api.answerInlineQuery(token = bot.getToken(), answerInlineQuery = result)
                        }
                        update.callbackQuery != null -> {
                            //TODO()
                        }
                    }
                }
            } catch (e: TgBotNotFoundException) {
                error("Bot {} not found via telegram request by token, dismissed from request pool", botUserName)
                return
            } catch (e: BotGetUpdatesConflictException) {
                error("Conflict detected. Going pause 120 sec. Bot {}", botUserName)
                needSleep = 120000
            } catch (e: Exception) {
                error(e.message, e)
                needSleep = 2000
            }

            if (needSleep > 0) {
                try {
                    sleep(needSleep)
                    needSleep = 0
                } catch (e1: InterruptedException) {
                    ok = false
                }

            }
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(LongPollProcess::class.java)

        fun error(message: String?, vararg o: Any) {
            try {
                log.error(message, o)
            } catch (e: Exception) {
                println(message ?: "Unknown error")
                println(e.message)
                e.printStackTrace()
            }
        }
    }
}

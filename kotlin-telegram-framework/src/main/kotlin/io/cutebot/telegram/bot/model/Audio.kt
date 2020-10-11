package io.cutebot.telegram.bot.model

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.TgAudio

class Audio(
        audio: TgAudio,
        telegramApi: TelegramApi,
        botToken: String
): Voice(audio, telegramApi, botToken) {
    val thumb = audio.thumb?.let { PhotoSize(audio.thumb, telegramApi, botToken) }
    val title = audio.title
    val performer = audio.performer
}

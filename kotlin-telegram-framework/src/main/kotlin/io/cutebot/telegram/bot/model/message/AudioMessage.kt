package io.cutebot.telegram.bot.model.message

import io.cutebot.telegram.bot.model.Audio
import io.cutebot.telegram.client.model.TgAudio

class AudioMessage(message: RawMessage, audio: TgAudio): Message(message) {
    val audio: Audio = Audio(audio, message.telegramApi, message.botToken)
}

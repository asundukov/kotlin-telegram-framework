package io.cutebot.telegram.bot.model.message

import io.cutebot.telegram.bot.model.Voice
import io.cutebot.telegram.client.model.TgVoice

class VoiceMessage(message: RawMessage, voice: TgVoice): Message(message) {
    val voice: Voice = Voice(voice, message.telegramApi, message.botToken)
}

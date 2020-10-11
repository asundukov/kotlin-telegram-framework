package io.cutebot.telegram.bot.model.message

import io.cutebot.telegram.bot.model.VideoNote
import io.cutebot.telegram.client.model.TgVideoNote

class VideoNoteMessage(
        message: RawMessage,
        tgVideoNote: TgVideoNote
): Message(message) {
    val videoNote: VideoNote = VideoNote(tgVideoNote, message.telegramApi, message.botToken)
}

package io.cutebot.telegram.bot.model.message

import io.cutebot.telegram.bot.model.Message
import io.cutebot.telegram.bot.model.Video
import io.cutebot.telegram.client.model.TgVideo

class VideoMessage(
        message: RawMessage,
        tgVideo: TgVideo
): Message(message) {
    val video: Video = Video(tgVideo, message.telegramApi, message.botToken)
    val message: String = message.caption ?: ""
}

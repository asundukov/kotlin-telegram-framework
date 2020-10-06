package io.cutebot.telegram.bot.model

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.TgVideo

class Video internal constructor(
        tgVideo: TgVideo,
        api: TelegramApi,
        token: String
): FileItem(api, token, tgVideo) {
    val mimeType: String? = tgVideo.mimeType
    val fileSize: Int? = tgVideo.fileSize
    val width: Int = tgVideo.width
    val height: Int = tgVideo.height
    val duration: Int = tgVideo.duration
    val thumb: PhotoSize? = tgVideo.thumb?.let { PhotoSize(it, api,token) }
}

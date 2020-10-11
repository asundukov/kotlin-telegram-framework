package io.cutebot.telegram.bot.model

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.TgVideoNote

class VideoNote internal constructor(
        tgVideoNote: TgVideoNote,
        api: TelegramApi,
        token: String
): FileItem(api, token, tgVideoNote) {
    val fileSize: Int? = tgVideoNote.fileSize
    val length: Int = tgVideoNote.length
    val duration: Int = tgVideoNote.duration
    val thumb: PhotoSize? = tgVideoNote.thumb?.let { PhotoSize(it, api,token) }
}

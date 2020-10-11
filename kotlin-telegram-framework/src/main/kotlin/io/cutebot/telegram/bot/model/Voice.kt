package io.cutebot.telegram.bot.model

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.TgVoice

open class Voice internal constructor(
        tgVoice: TgVoice,
        api: TelegramApi,
        token: String
): FileItem(api, token, tgVoice) {
    val fileSize: Int? = tgVoice.fileSize
    val duration: Int = tgVoice.duration
    val mimeType: String? = tgVoice.mimeType
}

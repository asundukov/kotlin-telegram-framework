package io.cutebot.telegram.bot.model

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.photo.TgPhotoSize

class PhotoSize internal constructor(
        tgPhotoSize: TgPhotoSize,
        api: TelegramApi,
        token: String
): FileItem(api, token, tgPhotoSize) {

    val width: Int = tgPhotoSize.width
    val height: Int = tgPhotoSize.height
    val size: Int? = tgPhotoSize.fileSize

}

package io.cutebot.telegram.bot.model

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.photo.TgPhotoSize

class PhotoSize internal constructor(
        tgPhotoSize: TgPhotoSize,
        api: TelegramApi,
        token: String
): FileItem(api, token, tgPhotoSize) {

    val data: PhotoData = PhotoData(tgPhotoSize.width, tgPhotoSize.height, tgPhotoSize.fileSize)

}

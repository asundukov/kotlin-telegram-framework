package io.cutebot.telegram.bot.model

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.photo.TgPhotoSize

class Photo internal constructor(
        tgPhotoSizes: List<TgPhotoSize>,
        api: TelegramApi,
        token: String
) {

    private val photoSizes: List<PhotoSize> = tgPhotoSizes.map { PhotoSize(it, api, token) }

    fun sizes(): List<PhotoSize> {
        return photoSizes
    }

    fun large(): PhotoSize {
        return photoSizes.maxBy { it.data.width }!!
    }

    fun small(): PhotoSize {
        return photoSizes.minBy { it.data.width }!!
    }

}

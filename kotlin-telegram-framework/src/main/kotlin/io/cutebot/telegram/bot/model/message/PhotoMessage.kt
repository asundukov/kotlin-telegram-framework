package io.cutebot.telegram.bot.model.message

import io.cutebot.telegram.bot.model.Message
import io.cutebot.telegram.bot.model.Photo
import io.cutebot.telegram.client.model.photo.TgPhotoSize

class PhotoMessage(
        message: RawMessage,
        photos: List<TgPhotoSize>
): Message(message) {
    val photo: Photo = Photo(photos, message.telegramApi, message.botToken)
    val message: String = message.caption ?: ""
}

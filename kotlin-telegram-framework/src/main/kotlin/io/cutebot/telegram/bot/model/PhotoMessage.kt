package io.cutebot.telegram.bot.model

import io.cutebot.telegram.client.model.photo.TgPhotoSize

class PhotoMessage(
        message: RawMessage,
        photos: List<TgPhotoSize>
): Message(message) {
    val photo: Photo = Photo(photos, message.telegramApi, message.botToken)
}

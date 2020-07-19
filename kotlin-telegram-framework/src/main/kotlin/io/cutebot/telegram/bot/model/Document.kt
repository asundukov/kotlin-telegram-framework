package io.cutebot.telegram.bot.model

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.TgDocument

class Document internal constructor(
        tgDocument: TgDocument,
        api: TelegramApi,
        token: String
): FileItem(api, token, tgDocument) {
    val fileName: String? = tgDocument.fileName
    val mimeType: String? = tgDocument.mimeType
    val fileSize: Int? = tgDocument.fileSize
    val thumb: PhotoSize? = tgDocument.thumb?.let { PhotoSize(it, api,token) }
}

package io.cutebot.telegram.bot.model

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.TgFile
import io.cutebot.telegram.client.model.TgFilePath
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.URL

abstract class FileItem internal constructor(
        private val api: TelegramApi,
        private val token: String,

        file: TgFile
) {
    val fileId = file.fileId
    val uniqueId = file.fileUniqueId

    private var downloadUrl: String? = null
    private var tgFilePath: TgFilePath? = null

    fun getFile(): File {
        val file = File.createTempFile(tmpPrefix, null)
        file.deleteOnExit()

        val out = FileOutputStream(file)
        getInputStream().transferTo(out)

        return file
    }

    fun getInputStream(): InputStream {
        return URL(getRemotePath()).openStream();
    }

    fun getRemotePath(): String {
        if (downloadUrl == null) {
            downloadUrl = api.getDownloadUrl(token, getTgFile().filePath)
        }
        return downloadUrl!!

    }

    private fun getTgFile(): TgFilePath {
        if (tgFilePath == null) {
            tgFilePath = api.getFile(token, fileId)
        }
        return tgFilePath!!
    }

    companion object {
        private const val tmpPrefix = "bot-tmp-"
    }

}
package io.cutebot.telegram.client

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.cutebot.telegram.client.model.TgBotCommands
import io.cutebot.telegram.client.model.TgChat
import io.cutebot.telegram.client.model.TgChatAction
import io.cutebot.telegram.client.model.TgFilePath
import io.cutebot.telegram.client.model.TgForwardMessage
import io.cutebot.telegram.client.model.TgMessage
import io.cutebot.telegram.client.model.TgResponseUpdate
import io.cutebot.telegram.client.model.TgSendAnimation
import io.cutebot.telegram.client.model.TgSendDocument
import io.cutebot.telegram.client.model.TgSendPhoto
import io.cutebot.telegram.client.model.TgSendTextMessage
import io.cutebot.telegram.client.model.TgUser
import io.cutebot.telegram.client.model.TgUserProfilePhotos
import io.cutebot.telegram.client.model.TgSetWebHook
import io.cutebot.telegram.client.model.inline.TgAnswerInlineQuery
import io.cutebot.telegram.client.model.response.TgResponseChat
import io.cutebot.telegram.client.model.response.TgResponseFile
import io.cutebot.telegram.client.model.response.TgResponseMessage
import io.cutebot.telegram.client.model.response.TgResponseUser
import io.cutebot.telegram.client.model.response.TgResponseUserProfilePhotos
import io.cutebot.telegram.exception.BotGetUpdatesConflictException
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.methods.HttpRequestBase
import org.apache.http.entity.ContentType
import org.apache.http.entity.ContentType.APPLICATION_JSON
import org.apache.http.entity.ContentType.TEXT_PLAIN
import org.apache.http.entity.StringEntity
import org.apache.http.entity.mime.MultipartEntity
import org.apache.http.entity.mime.content.FileBody
import org.apache.http.entity.mime.content.StringBody
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager
import org.slf4j.LoggerFactory


class TelegramApi(
        maxConnections: Int = 5000
) {

    private val connectionManager = PoolingHttpClientConnectionManager()
    init {
        connectionManager.maxTotal = maxConnections
        connectionManager.defaultMaxPerRoute = maxConnections
    }

    private val objectMapper = jacksonObjectMapper()
    private val httpClient = HttpClientBuilder
            .create()
            .setConnectionManager(connectionManager)
            .build()

    fun getMe(token: String): TgUser {
        val response = getMethod(token, "getMe")
        return objectMapper.readValue(response.content, TgResponseUser::class.java).result!!
    }

    fun getChat(token: String, id: Long): TgChat {
        val response = getMethod(token, "getChat?chat_id=$id")
        return objectMapper.readValue(response.content, TgResponseChat::class.java).result!!
    }

    fun getFile(token: String, fileId: String): TgFilePath {
        val response = getMethod(token, "getFile?file_id=$fileId")
        return objectMapper.readValue(response.content, TgResponseFile::class.java).result!!
    }

    fun getUpdates(token: String, offset: Int, limit: Int, timeout: Int): TgResponseUpdate {
        val method = "getUpdates?offset=$offset&limit=$limit&timeout=$timeout"
        val response = getMethod(token, method)

        if (response.code == 409) {
            val shortToken = token.substring(0, 15) + "..."
            log.warn("409 conflict on receive updates for bot token {} with message {}",
                    shortToken, String(response.content))
            throw BotGetUpdatesConflictException()
        }

        return objectMapper.readValue(response.content, TgResponseUpdate::class.java)
    }

    fun sendPhoto(token: String, sendPhoto: TgSendPhoto): TgMessage {
        val url = getUrl(token, "sendPhoto")
        val reqEntity = MultipartEntity()
        reqEntity.addPart("photo", FileBody(sendPhoto.photo))
        reqEntity.addPart("chat_id", StringBody(sendPhoto.chatId.toString(), TEXT_PLAIN))
        sendPhoto.caption?.let {
            reqEntity.addPart("caption", StringBody(it, ContentType.create(TEXT_PLAIN.mimeType, Charsets.UTF_8)))
            reqEntity.addPart("parse_mode", StringBody(sendPhoto.parseMode, TEXT_PLAIN))
        }
        sendPhoto.replyMarkup?.let {
            reqEntity.addPart("reply_markup", StringBody(objectMapper.writeValueAsString(it), APPLICATION_JSON))
        }

        return postMultipartData(reqEntity, url)
    }

    fun sendDocument(token: String, document: TgSendDocument): TgMessage {
        val url = getUrl(token, "sendDocument")
        val reqEntity = MultipartEntity()

        reqEntity.addPart("document", FileBody(document.document))
        reqEntity.addPart("chat_id", StringBody(document.chatId.toString()))

        document.caption?.let {
            reqEntity.addPart("caption", StringBody(it, ContentType.create(TEXT_PLAIN.mimeType, Charsets.UTF_8)))
            reqEntity.addPart("parse_mode", StringBody(document.parseMode, TEXT_PLAIN))
        }
        document.replyMarkup?.let {
            reqEntity.addPart("reply_markup", StringBody(objectMapper.writeValueAsString(it), APPLICATION_JSON))
        }

        return postMultipartData(reqEntity, url)
    }

    private fun postMultipartData(entity: MultipartEntity, url: String): TgMessage {

        val httpPost = HttpPost(url)
        httpPost.entity = entity

        val response = httpClient.execute(httpPost)

        val r = response.entity.content.reader().readText()

        return objectMapper
                .readerFor(TgResponseMessage::class.java)
                .readValue(r, TgResponseMessage::class.java).result!!

    }


    fun sendAnimation(token: String, animation: TgSendAnimation): TgMessage {
        val response = postMethod(token, animation, "sendAnimation")
        return objectMapper.readValue(response.content, TgResponseMessage::class.java).result!!
    }

    fun sendMessage(token: String, sendMessage: TgSendTextMessage): TgMessage {
        val response = postMethod(token, sendMessage, "sendMessage")
        return objectMapper.readValue(response.content, TgResponseMessage::class.java).result!!
    }

    fun forwardMessage(token: String, forwardMessage: TgForwardMessage): TgMessage {
        val response = postMethod(token, forwardMessage, "forwardMessage")
        return objectMapper.readValue(response.content, TgResponseMessage::class.java).result!!
    }

    fun setCommands(token: String, tgCommands: TgBotCommands) {
        postMethod(token, tgCommands, "setMyCommands")
    }

    fun sendChatAction(token: String, action: TgChatAction) {
        postMethod(token, action, "sendChatAction")
    }

    fun getUserProfilePhotos(token: String, userId: Long): TgUserProfilePhotos {
        val method = "getUserProfilePhotos?user_id=$userId"
        val response = getMethod(token, method)
        return objectMapper.readValue(response.content, TgResponseUserProfilePhotos::class.java).result!!
    }


    fun updateMessage(botToken: String, sendMessage: TgSendTextMessage, updateMessageId: Long?): TgMessage {
        sendMessage.messageId = updateMessageId
        val response = postMethod(botToken, sendMessage, "editMessageText")
        return objectMapper.readValue(response.content, TgResponseMessage::class.java).result!!
    }

    fun answerInlineQuery(token: String, answerInlineQuery: TgAnswerInlineQuery) {
        postMethod(token, answerInlineQuery, "answerInlineQuery")
    }

    fun setWebHook(token: String, webHookUrl: String) {
        val setWebHookDto = TgSetWebHook("$webHookUrl/webhook/$token")
        postMethod(token, setWebHookDto, "setWebhook")
    }

    fun deleteWebhook(token: String) {
        getMethod(token, "deleteWebhook")
    }

    fun getDownloadUrl(token: String, filePath: String): String {
        return "https://api.telegram.org/file/bot$token/$filePath"
    }

    fun downloadFile(token: String, fileId: String): String {
        val url = getDownloadUrl(token, fileId)

        val request = HttpGet(url)
        log.info("GET FILE {}", fileId)
        return String(execute(request).content)
    }

    private fun postMethod(token: String, request: Any, methodName: String): BufferedEntity {
        val url = getUrl(token, methodName)
        val requestString = objectMapper.writeValueAsString(request)
        val requestEntity = StringEntity(requestString, ContentType.APPLICATION_JSON)

        val post = HttpPost(url)
        post.entity = requestEntity

        log.debug("POST {} to {}", request, methodName)
        return execute(post)
    }

    private fun getMethod(token: String, methodName: String): BufferedEntity {
        val url = getUrl(token, methodName)
        val request = HttpGet(url)
        log.debug("GET {}", methodName)
        return execute(request)
    }

    private fun execute(request: HttpRequestBase): BufferedEntity {
        val response = httpClient.execute(request)

        val content = response.entity.content.reader().readText()

        log.debug("RESPONSE {}", content)

        return BufferedEntity(response.statusLine.statusCode, content.toByteArray())
    }

    private fun getUrl(token: String, methodName: String): String {
        return "https://api.telegram.org/bot$token/$methodName"
    }

    companion object {
        private val log = LoggerFactory.getLogger(TelegramApi::class.java)
    }

    class BufferedEntity(
            val code: Int,
            val content: ByteArray
    )

}

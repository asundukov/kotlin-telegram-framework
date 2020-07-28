package io.cutebot.telegram.interaction.model

import io.cutebot.telegram.client.TelegramApi
import io.cutebot.telegram.client.model.keyboard.TgInlineKeyboardButton
import io.cutebot.telegram.client.model.keyboard.TgInlineKeyboardMarkup
import io.cutebot.telegram.client.model.keyboard.TgKeyboard
import io.cutebot.telegram.client.model.keyboard.TgKeyboardRemove
import io.cutebot.telegram.interaction.model.message.ChatAnswerSendDocument
import io.cutebot.telegram.interaction.model.message.ChatAnswerSendPhoto
import io.cutebot.telegram.interaction.model.message.ChatAnswerSendText
import java.io.File
import java.util.Collections
import java.util.Collections.singletonList


interface ChatAnswer {

    fun fireAction(api: TelegramApi, token: String, chatId: Long)

    companion object {
        fun noAnswer(): ChatAnswer {
            return ChatAnswerNothing()
        }

        fun text(text: String, keyboard: TgKeyboard = TgKeyboardRemove()): ChatAnswer {
            return ChatAnswerSendText(text, keyboard)
        }

        fun photo(file: File, caption: String = "", keyboard: TgKeyboard = TgKeyboardRemove()): ChatAnswer {
            return ChatAnswerSendPhoto(file, caption, keyboard)
        }

        fun document(file: File, caption: String = "", keyboard: TgKeyboard = TgKeyboardRemove()): ChatAnswer {
            return ChatAnswerSendDocument(file, caption, keyboard)
        }

        fun inlineQueryInvitation(text: String, buttonText: String, query: String): ChatAnswer {
            val keyboard = TgInlineKeyboardMarkup(singletonList(singletonList(TgInlineKeyboardButton(
                    text = buttonText,
                    switchInlineQueryCurrentChat = query
            ))))
            return text(text, keyboard)
        }

        fun inlineQueryInvitationChatSelection(text: String, buttonText: String, query: String): ChatAnswer {
            val keyboard = TgInlineKeyboardMarkup(singletonList(singletonList(TgInlineKeyboardButton(
                    text = buttonText,
                    switchInlineQuery = query
            ))))
            return text(text, keyboard)
        }

        fun actionTextTyping(): ChatAnswer {
            return ChatAnswerSendAction.typing()
        }
        fun actionUploadPhoto(): ChatAnswerSendAction {
            return ChatAnswerSendAction.uploadPhoto()
        }
        fun actionRecordVideo(): ChatAnswerSendAction {
            return ChatAnswerSendAction.recordVideo()
        }
        fun actionUploadVideo(): ChatAnswerSendAction {
            return ChatAnswerSendAction.uploadVideo()
        }
        fun actionRecordAudio(): ChatAnswerSendAction {
            return ChatAnswerSendAction.recordAudio()
        }
        fun actionUploadAudio(): ChatAnswerSendAction {
            return ChatAnswerSendAction.uploadAudio()
        }
        fun actionUploadDocument(): ChatAnswerSendAction {
            return ChatAnswerSendAction.uploadDocument()
        }
        fun actionFindLocation(): ChatAnswerSendAction {
            return ChatAnswerSendAction.findLocation()
        }
        fun actionRecordVideoNote(): ChatAnswerSendAction {
            return ChatAnswerSendAction.recordVideoNote()
        }
        fun actionUploadVideoNote(): ChatAnswerSendAction {
            return ChatAnswerSendAction.uploadVideoNote()
        }
    }
}

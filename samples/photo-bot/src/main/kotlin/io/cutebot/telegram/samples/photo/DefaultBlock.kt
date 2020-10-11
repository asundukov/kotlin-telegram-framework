package io.cutebot.telegram.samples.photo

import io.cutebot.telegram.bot.block.BotBlock
import io.cutebot.telegram.bot.block.BotTextBlock
import io.cutebot.telegram.bot.model.message.DocumentMessage
import io.cutebot.telegram.bot.model.message.PhotoMessage
import io.cutebot.telegram.bot.model.message.TextMessage
import io.cutebot.telegram.bot.model.message.VideoMessage
import io.cutebot.telegram.interaction.model.ChatAnswer
import java.io.File


class DefaultBlock(
        private var receivedFile: File? = null
): BotTextBlock {

    override fun getAnswer(): ChatAnswer {
        return if (receivedFile != null) {
            ChatAnswer.document(receivedFile!!, "Here it is!")
        } else {
            ChatAnswer.text("Send me photo or file.")
        }
    }

    override fun handleText(message: TextMessage) = this

    override fun handlePhoto(message: PhotoMessage): BotBlock {
        receivedFile = message.photo.large().getFile()
        return this
    }

    override fun handleDocument(message: DocumentMessage): BotBlock {
        receivedFile = message.document.getFile()
        return this
    }

    override fun handleVideo(message: VideoMessage): BotBlock {
        receivedFile = message.video.getFile()
        return this
    }

}

package io.cutebot.telegram.bot.block

import io.cutebot.telegram.bot.model.message.AudioMessage
import io.cutebot.telegram.bot.model.message.ContactMessage
import io.cutebot.telegram.bot.model.message.DocumentMessage
import io.cutebot.telegram.bot.model.message.LocationMessage
import io.cutebot.telegram.bot.model.message.PhotoMessage
import io.cutebot.telegram.bot.model.message.VideoMessage
import io.cutebot.telegram.bot.model.message.VideoNoteMessage
import io.cutebot.telegram.bot.model.message.VoiceMessage

interface BotTextBlock: BotBlock {
    override fun handlePhoto(message: PhotoMessage): BotBlock {
        return this
    }

    override fun handleDocument(message: DocumentMessage): BotBlock {
        return this
    }

    override fun handleVideo(message: VideoMessage): BotBlock {
        return this
    }

    override fun handleVideoNote(message: VideoNoteMessage): BotBlock {
        return this
    }

    override fun handleVoice(message: VoiceMessage): BotBlock {
        return this
    }

    override fun handleAudio(message: AudioMessage): BotBlock {
        return this
    }

    override fun handleContact(message: ContactMessage): BotBlock {
        return this
    }

    override fun handleLocation(message: LocationMessage): BotBlock {
        return this
    }

}

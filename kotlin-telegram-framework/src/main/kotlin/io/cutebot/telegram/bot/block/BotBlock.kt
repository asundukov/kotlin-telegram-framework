package io.cutebot.telegram.bot.block

import io.cutebot.telegram.bot.model.Location
import io.cutebot.telegram.bot.model.message.AudioMessage
import io.cutebot.telegram.bot.model.message.ContactMessage
import io.cutebot.telegram.bot.model.message.DocumentMessage
import io.cutebot.telegram.bot.model.message.LocationMessage
import io.cutebot.telegram.bot.model.message.PhotoMessage
import io.cutebot.telegram.bot.model.message.TextMessage
import io.cutebot.telegram.bot.model.message.VideoMessage
import io.cutebot.telegram.bot.model.message.VideoNoteMessage
import io.cutebot.telegram.bot.model.message.VoiceMessage
import io.cutebot.telegram.interaction.model.ChatAnswer

interface BotBlock {

    fun getAnswer(): ChatAnswer

    fun handleText(message: TextMessage): BotBlock
    fun handlePhoto(message: PhotoMessage): BotBlock
    fun handleDocument(message: DocumentMessage): BotBlock
    fun handleVideo(message: VideoMessage): BotBlock
    fun handleVideoNote(message: VideoNoteMessage): BotBlock
    fun handleVoice(message: VoiceMessage): BotBlock
    fun handleContact(message: ContactMessage): BotBlock
    fun handleLocation(message: LocationMessage): BotBlock
    fun handleAudio(message: AudioMessage): BotBlock
}

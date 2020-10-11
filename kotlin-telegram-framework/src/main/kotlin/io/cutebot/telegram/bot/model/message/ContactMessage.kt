package io.cutebot.telegram.bot.model.message

import io.cutebot.telegram.bot.model.Contact
import io.cutebot.telegram.client.model.TgContact

class ContactMessage(
        message: RawMessage,
        contact: TgContact
): Message(message) {
    val contact: Contact = Contact(contact)
}

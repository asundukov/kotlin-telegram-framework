package io.cutebot.telegram.bot.model

import io.cutebot.telegram.client.model.TgContact

class Contact internal constructor(
        tgContact: TgContact
) {
    val phoneNumber = tgContact.phoneNumber

    val firstName = tgContact.firstName

    val lastName = tgContact.lastName ?: ""

    val userId = tgContact.userId

    val vcard = tgContact.vcard
}

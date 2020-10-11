package io.cutebot.telegram.bot.model.message

import io.cutebot.telegram.bot.model.Location
import io.cutebot.telegram.client.model.TgVenue

class LocationMessage(
        message: RawMessage,
        venue: TgVenue
): Message(message) {
    val location: Location = Location(venue)
}

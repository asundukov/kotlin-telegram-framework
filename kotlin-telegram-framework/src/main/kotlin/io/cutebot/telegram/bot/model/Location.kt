package io.cutebot.telegram.bot.model

import io.cutebot.telegram.client.model.TgVenue

class Location internal constructor(
        tgVenue: TgVenue
) {
    val longitude = tgVenue.location.longitude

    val latitude = tgVenue.location.latitude

    val address = tgVenue.address

    val title = tgVenue.title

    val foursquareId = tgVenue.foursquareId

    val foursquareType = tgVenue.foursquareType
}

package io.cutebot.telegram.samples.statefulbot

class Hero(
        var hp: Int = 10,
        var money: Int = 3
) {
    fun getStatus(): String {
        return "<b>Hero</b>\nhp: $hp\nmoney: $money\n"
    }
}

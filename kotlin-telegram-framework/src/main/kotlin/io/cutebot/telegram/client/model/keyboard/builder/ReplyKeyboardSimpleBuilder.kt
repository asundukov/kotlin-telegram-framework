package io.cutebot.telegram.client.model.keyboard.builder

import io.cutebot.telegram.client.model.keyboard.TgKeyboardButton
import io.cutebot.telegram.client.model.keyboard.TgReplyKeyboardMarkup

class ReplyKeyboardSimpleBuilder {
    private val builder = ReplyKeyboardBuilder()
    fun nextRow(): ReplyKeyboardSimpleBuilder {
        builder.nextRow();
        return this
    }

    fun addElement(title: String): ReplyKeyboardSimpleBuilder {
        builder.addElement(TgKeyboardButton(title))
        return this
    }

    fun addRow(vararg title: String): ReplyKeyboardSimpleBuilder {
        val list = title.map { TgKeyboardButton(it) }.toTypedArray()
        builder.addRow(*list)
        return this
    }

    fun build(): TgReplyKeyboardMarkup {
        return TgReplyKeyboardMarkup(builder.build())
    }

    fun oneButton(title: String): TgReplyKeyboardMarkup {
        return TgReplyKeyboardMarkup(builder.oneButton(TgKeyboardButton(title)))
    }
}

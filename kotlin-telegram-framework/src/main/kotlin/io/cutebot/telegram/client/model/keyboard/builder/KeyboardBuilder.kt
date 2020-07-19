package io.cutebot.telegram.client.model.keyboard.builder

abstract class KeyboardBuilder<T> {
    private val keyboard = ArrayList<ArrayList<T>>()

    fun nextRow(): KeyboardBuilder<T> {
        keyboard.add(ArrayList())
        return this
    }

    fun addElement(e: T): KeyboardBuilder<T> {
        keyboard.last().add(e)
        return this
    }

    fun addRow(vararg elements: T): KeyboardBuilder<T> {
        nextRow()
        for (item in elements) {
            addElement(item)
        }
        return this
    }

    fun build(): List<List<T>> {
        return keyboard
    }

    fun oneButton(e: T): List<List<T>> {
        return nextRow().addElement(e).build()
    }
}
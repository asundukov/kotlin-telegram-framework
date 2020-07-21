package io.cutebot.telegram.bot.commandextractor

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class DefaultCommandExtractorTest {

    private val extractor: DefaultCommandExtractor = DefaultCommandExtractor()

    @Test
    fun `isCommand for real command`() {
        assertTrue(isCommand("/start"))
    }

    @Test
    fun `isCommand false for not real command`() {
        assertFalse(isCommand("start"))
    }

    @Test
    fun `isCommand false for broken command`() {
        assertFalse(isCommand("/"))
    }

    @Test
    fun `extractCommand just command`() {
        val (cmd, query) = extract("/start")
        assertEquals("/start", cmd)
        assertEquals(query, "")
    }

    @Test
    fun `extractCommand just command + _`() {
        val (cmd, query) = extract("/start_")
        assertEquals("/start", cmd)
        assertEquals(query, "")
    }

    @Test
    fun `extractCommand just command _ query`() {
        val (cmd, query) = extract("/start_2+2")
        assertEquals("/start", cmd)
        assertEquals(query, "2+2")
    }

    @Test
    fun `extractCommand just command + query`() {
        val (cmd, query) = extract("/start_2+2")
        assertEquals("/start", cmd)
        assertEquals(query, "2+2")
    }

    private fun isCommand(text: String): Boolean {
        return extractor.isCommand(text)
    }

    private fun extract(text: String): CommandWithParams {
        return extractor.extractCommand(text)
    }
}
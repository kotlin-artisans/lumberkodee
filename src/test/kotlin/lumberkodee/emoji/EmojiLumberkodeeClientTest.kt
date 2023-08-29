/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package lumberkodee.emoji

import lumberkodee.LogLevel
import kotlin.test.Test
import kotlin.test.assertTrue

class EmojiLumberkodeeClientTest {

    @Test
    fun supportsAllLevels() {
        val client = EmojiLumberkodeeClient()
        val supportsAllLevels = !LogLevel.values().any { !client.supports(it) }

        assertTrue(supportsAllLevels)
    }
}
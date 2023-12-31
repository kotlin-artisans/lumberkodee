/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.github.kotlinartisans.lumberkodee.console

import com.github.kotlinartisans.lumberkodee.LogLevel
import kotlin.test.Test
import kotlin.test.assertTrue

class ConsoleLumberkodeeClientTest {

    @Test
    fun supportsAllLevels() {
        val client = ConsoleLumberkodeeClient()
        val supportsAllLevels = !LogLevel.values().any { !client.supports(it) }

        assertTrue(supportsAllLevels)
    }
}

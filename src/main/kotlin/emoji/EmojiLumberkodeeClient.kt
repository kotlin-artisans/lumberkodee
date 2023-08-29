package emoji

import lumberkodee.LogLevel
import lumberkodee.LumberkodeeClient

/**
 * A rather simple [LumberkodeeClient] that uses [println] + emojis to log messages to console/stdout.
 */
class EmojiLumberkodeeClient : LumberkodeeClient {
    override fun supports(level: LogLevel) = true

    override fun info(message: String, extras: Map<String, String>) =
        println("[ℹ\uFE0F]: $message (extras: $extras)")

    override fun warning(message: String, extras: Map<String, String>) =
        println("[⚠\uFE0F]: $message (extras: $extras)")

    override fun error(message: String, throwable: Throwable, extras: Map<String, String>) =
        println("[\uD83D\uDC80]: $message (throwable: $throwable | extras: $extras)")

    override fun debug(message: String, extras: Map<String, String>) =
        println("[\uD83E\uDD16]: $message (extras: $extras)")

    override fun verbose(message: String, extras: Map<String, String>) =
        println("[\uD83D\uDC1B]: $message (extras: $extras)")
}

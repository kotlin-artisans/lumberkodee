package console

import lumberkodee.LogLevel
import lumberkodee.LumberkodeeClient

/**
 * A rather simple [LumberkodeeClient] that uses [println] to log messages to console/stdout.
 */
class ConsoleLumberkodeeClient : LumberkodeeClient {
    override fun supports(level: LogLevel) = true

    override fun info(message: String, extras: Map<String, String>) =
        println("[info]: $message (extras: $extras)")

    override fun warning(message: String, extras: Map<String, String>) =
        println("[warning]: $message (extras: $extras)")

    override fun error(message: String, throwable: Throwable, extras: Map<String, String>) =
        println("[error]: $message (throwable: $throwable | extras: $extras)")

    override fun debug(message: String, extras: Map<String, String>) =
        println("[debug]: $message (extras: $extras)")

    override fun verbose(message: String, extras: Map<String, String>) =
        println("[verbose]: $message (extras: $extras)")
}

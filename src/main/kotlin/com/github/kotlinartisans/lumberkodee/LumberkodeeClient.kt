package com.github.kotlinartisans.lumberkodee

/**
 * An interface for logging messages. Extend it to your own desires and styling and then
 * put it to work with [putLumberkodeeToWork] function.
 */
interface LumberkodeeClient {

    /**
     * Indicates if the client supports logs of level: [level].
     *
     * This check should be implemented with a algorithmic complexity of `O(1)`, since it will be
     * used to filter undesired log requests.
     */
    fun supports(level: LogLevel): Boolean

    /**
     * Logs an informational message.
     *
     * @param message - content of the message as string.
     * @param extras - a set of additional values that may be useful for the client when logging the message.
     */
    fun info(message: String, extras: Map<String, String>)

    /**
     * Logs a warning message.
     *
     * @param message - content of the message as string.
     * @param extras - a set of additional values that may be useful for the client when logging the message.
     */
    fun warning(message: String, extras: Map<String, String>)

    /**
     * Logs an error message.
     *
     * @param message - content of the message as string.
     * @param throwable - an additional throwable that reports an exception.
     * @param extras - a set of additional values that may be useful for the client when logging the message.
     */
    fun error(message: String, throwable: Throwable, extras: Map<String, String>)

    /**
     * Logs a debug message.
     *
     * @param message - content of the message as string.
     * @param extras - a set of additional values that may be useful for the client when logging the message.
     */
    fun debug(message: String, extras: Map<String, String>)

    /**
     * Logs a verbose message.
     *
     * @param message - content of the message as string.
     * @param extras - a set of additional values that may be useful for the client when logging the message.
     */
    fun verbose(message: String, extras: Map<String, String>)
}

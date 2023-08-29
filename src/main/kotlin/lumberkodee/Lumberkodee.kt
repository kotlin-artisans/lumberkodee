package lumberkodee

val EMPTY_EXTRAS = emptyMap<String, String>()
val EMPTY_THROWABLE = Throwable()

/**
 * Global store of all [LumberkodeeClient] that have been put to work. These clients are stored
 * in the program heap, so they will still exist when new threads or coroutines are spawned.
 */
val clients = arrayListOf<LumberkodeeClient>()

/**
 * Puts a list of [LumberkodeeClient] to work.
 */
fun putLumberkodeeToWork(lumberkodeeClients: List<LumberkodeeClient>) = clients.apply {
    clear()
    addAll(lumberkodeeClients)
}

/**
 * Top-level function that requests an informational message to be logged.
 *
 * @param message - content of the message as string.
 * @param extras - a set of additional values that may be useful for the client when logging the message.
 */
fun logInfo(message: String, extras: Map<String, String> = EMPTY_EXTRAS) =
    clients.filter { it.supports(LogLevel.INFO) }.forEach { it.info(message, extras) }

/**
 * Top-level function that requests a warning message to be logged.
 *
 * @param message - content of the message as string.
 * @param extras - a set of additional values that may be useful for the client when logging the message.
 */
fun logWarning(message: String, extras: Map<String, String> = EMPTY_EXTRAS) =
    clients.filter { it.supports(LogLevel.WARNING) }.forEach { it.warning(message, extras) }

/**
 * Top-level function that requests an error message to be logged.
 *
 * @param message - content of the message as string.
 * @param throwable - an additional throwable that reports an exception.
 * @param extras - a set of additional values that may be useful for the client when logging the message.
 */
fun logError(
    message: String,
    throwable: Throwable = EMPTY_THROWABLE,
    extras: Map<String, String> = EMPTY_EXTRAS
) =
    clients.filter { it.supports(LogLevel.ERROR) }
        .forEach { it.error(message, throwable = throwable, extras = extras) }

/**
 * Top-level function that requests a debug message to be logged.
 *
 * @param message - content of the message as string.
 * @param extras - a set of additional values that may be useful for the client when logging the message.
 */
fun logDebug(message: String, extras: Map<String, String> = EMPTY_EXTRAS) =
    clients.filter { it.supports(LogLevel.DEBUG) }.forEach { it.debug(message, extras) }

/**
 * Top-level function that requests a verbose message to be logged.
 *
 * @param message - content of the message as string.
 * @param extras - a set of additional values that may be useful for the client when logging the message.
 */
fun logVerbose(message: String, extras: Map<String, String> = EMPTY_EXTRAS) =
    clients.filter { it.supports(LogLevel.VERBOSE) }.forEach { it.verbose(message, extras) }
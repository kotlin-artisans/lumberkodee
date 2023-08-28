# lumberkodee

A simple, yet clean, top-level logging API with support for multiple clients with zero modification fees 🪵

---

## How to use

Lumberkodee comes with bateries included, so you can go straight ahead and try it with either `emoji` and `console` clients:

```kotlin
import com.github.kotlinartisans.lumberkodee.*

// Provide lumberkodee clients that will log messages.
val clients = [ConsoleLumberkodeeClient(), EmojiLumberkodeeClient()]

// Put them to work!
putLumberkodeeToWork(clients)

// Start logging from top level API.
logInfo('My first lumberkodee logging message!')
```

However, if the bundled clients do not fit your style, you can easily create a new lumberkodee client.
Start by defining an implementation of [LumberkodeeClient](src/main/kotlin/lumberkodee/Client.kt):

```kotlin
import com.github.kotlinartisans.lumberkodee.LumberkodeeClient

class KaomojiLumberkodeeClient extends LumberkodeeClient {}
```

Then, implement the API logging methods:

```kotlin
override fun supports(level: LogLevel) = true

override fun info(message: String, extras: Map<String, String>) {
    println("(◕‿◕) (${message}) | Extras: $extras")
}

override fun warning(message: String, extras: Map<String, String>) {
    println("(⇀‸↼‶) (${message}) | Extras: $extras")
}

override fun error(message: String, throwable: Throwable, extras: Map<String, String>) {
    println("(｡•́︿•̀｡) (${message}) | Exception: $throwable | Extras: $extras")
}

override fun debug(message: String, extras: Map<String, String>) {
    println("╚═། ◑ ▃ ◑ །═╝ (${message}) | Extras: $extras")
}

override fun verbose(message: String, extras: Map<String, String>) {
    println("(=^ ◡ ^=) (${message}) | Extras: $extras")
}
```

Once the new client is implemented, you can go ahead and put it to work and it will work out of the box!

```kotlin
import com.github.kotlinartisans.lumberkodee.putLumberkodeeToWork

val clients = [KaomojiLumberkodeeClient()]
putLumberkodeeToWork(clients)
```

## Features

- Clean and simple top-level logging API
- Easy to extend new behaviour by creating new clients
- Batteries included: use bundled clients `console` and `emoji`

---

## Bugs and Contributions

Found any bug (including typos) in the package? Do you have any suggestion
or feature to include for future releases? Please create an issue via
GitHub in order to track each contribution. Also, pull requests are very
welcome!

To contribute, start by setting up your local development environment. The [setup.md](setup.md) 
document will onboard you on how to do so!

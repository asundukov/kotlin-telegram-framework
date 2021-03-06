[![](https://jitpack.io/v/asundukov/kotlin-telegram-bot.svg)](https://jitpack.io/#asundukov/kotlin-telegram-bot)

# Kotlin telegram bot framework

Kotlin telegram framework for fast developing stateful bots.

Framework is in active developing currently.

*I will be grateful for any helpful pull requests*

### Examples
1. [@MemeBuilderBot](https://t.me/MemeBuilderBot) / [Source code](https://github.com/asundukov/meme-gen-manage-bot)
1. [@MemeGeneBot](https://t.me/MemeGeneBot) / [Source code](https://github.com/asundukov/meme-gen-bot)
1. [@MarksManageBot](https://t.me/MarksManageBot) / [Source code](https://githib.com/asundukov/mark-on-image-manage-bot)

### Usage
You can see samples at https://github.com/asundukov/kotlin-telegram-bot/tree/master/samples


#### As telegram bot api library
```Kotlin
fun main(args: Array<String>) {
    val api = TelegramApi()
    val updates = api.getUpdates(token, offset, limit, timeout)
    api.sendMessage(token, data)
}
```

#### Text bot
[Sources](https://github.com/asundukov/kotlin-telegram-bot/tree/master/samples/text-bot/src/main/kotlin/io/cutebot/telegram/samples/textbot)
```Kotlin
fun main(args: Array<String>) {
    val botToken = args[0]
    BotRunner().run(TextBot(botToken))
}

class TextBot(
        private val token: String
): SimpleTextBot() {
    private val counter = AtomicInteger(0)

    override fun handleText(text: String, from: TgUser, chat: TgChat): String {
        return "hello!\n this is message number " + counter.incrementAndGet().toString()
    }

    override fun getToken(): String {
        return token
    }
}
```

#### Stateful bot
[Sample source](https://github.com/asundukov/kotlin-telegram-bot/tree/master/samples/text-bot/src/main/kotlin/io/cutebot/telegram/samples/textbot)
```Kotlin
val bot = StatefulBotExample(botToken, StartBlock())
BotRunner().run(bot)
```
```Kotlin
class StatefulBotExample(
        private val token: String,
        currentBlock: BotBlock
): StatefulBot(currentBlock) {
    override fun getToken(): String {
        return token
    }
}
```
```Kotlin
class StartBlock(): BotTextBlock {
    override fun getAnswer(): ChatAnswer {
        return ChatAnswer.text("This is start block")
    }

    override fun handleText(message: TextMessage): BotBlock {
        val text = message.text
        //handle message
        return SecondBlock()
    }
}
```
```Kotlin
class StartBlock(): BotTextBlock {
    override fun getAnswer(): ChatAnswer {
        return ChatAnswer.text("This is second block")
    }

    override fun handleText(message: TextMessage): BotBlock {
        val text = message.text
        //handle message
        return StartBlock()
    }
}
```

#### Bot commands + stateful blocks
```Kotlin
class CommandsStatefulBotExample(
        private val token: String,
        currentBlock: BotBlock,
        commands: List<Command>
): CommandsStatefulBot(currentBlock, commands) {
    override fun getToken(): String {
        return token
    }
}
```
```Kotlin
class StartCommand: Command {
    override fun handleCommand(query: String, message: RawMessage): BotBlock {
        return StartBlock
    }

    override fun getCommand(): String {
        return "/start"
    }

    override fun getCommandDescription(): String {
        return "Restart bot"
    }

    override fun isSystemCommand(): Boolean {
        return true
    }
}
```



### Maven dependency
```xml
<dependency>
    <groupId>com.github.asundukov.kotlin-telegram-framework</groupId>
    <artifactId>kotlin-telegram-framework</artifactId>
    <version>1.0.1-beta-5</version>
</dependency>

```


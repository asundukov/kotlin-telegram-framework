package io.cutebot.telegram.bot

import io.cutebot.telegram.bot.block.BotBlock
import io.cutebot.telegram.bot.command.Command
import io.cutebot.telegram.bot.commandextractor.CommandExtractor
import io.cutebot.telegram.bot.commandextractor.DefaultCommandExtractor
import io.cutebot.telegram.bot.model.RawMessage
import io.cutebot.telegram.bot.model.settings.ChatMessagesStrategy
import io.cutebot.telegram.bot.model.settings.ChatMessagesStrategy.ALL
import io.cutebot.telegram.bot.model.settings.ChatMessagesStrategy.IGNORE
import io.cutebot.telegram.client.model.TgBotCommand
import io.cutebot.telegram.client.model.TgBotCommands
import io.cutebot.telegram.interaction.model.ChatAnswer
import org.slf4j.LoggerFactory

abstract class CommandsStatefulBot(
        currentBlock: BotBlock,
        commands: List<Command>,
        private val commandExtractor: CommandExtractor = DefaultCommandExtractor()
): StatefulBot(currentBlock) {

    val commandsMap: Map<String, Command> = commands
            .map { it.getCommand() to it }
            .toMap()

    override fun handleMessage(message: RawMessage): ChatAnswer {
        if (message.text != null
                && message.from != null && message.from.id == message.chat.id
                && commandExtractor.isCommand(message.text)) {
            val (command, query) = commandExtractor.extractCommand(message.text)

            val commandBlock = commandsMap[command]

            if (commandBlock != null) {
                currentBlock = commandBlock.handleCommand(query, message)
                return currentBlock.getAnswer()
            }
        }

        return chatAnswer(message)
    }

    override fun getCommands(): TgBotCommands? {
        var commands = commandsMap.values
                .filter { it.isSystemCommand() }

        commands.map { it.getCommand() }
                .filter { it.isEmpty() || it[0] != '/' }
                .forEach { warnReason(it, "system command must begin on '/' symbol") }

        commands.map { it.getCommand() }
                .filter { it.length == 1 }
                .forEach { warnReason(it, "system command cannot have just 1 symbol") }

        commands.filter { it.getCommandDescription().length < 3 }
                .forEach { warnReason(it.getCommand(), "description length less than 3 symbols") }

        commands = commands
                .filter { it.getCommand().length > 1 && it.getCommand()[0] == '/' }
                .filter { it.getCommandDescription().length >= 3 }

        if (commands.size > 100) {
            log.warn("Count of system commands more than 100 and will be truncated")
            commands = commands.subList(0, 100)
        }

        val tgCommands = commands.map {
            TgBotCommand(it.getCommand().substring(1), it.getCommandDescription())
        }

        return TgBotCommands(tgCommands)
    }

    companion object {
        private val log = LoggerFactory.getLogger(CommandsStatefulBot::class.java)

        fun warnReason(command: String, reason: String) {
            log.warn("command {} cannot be system: {}", command, reason)
        }
    }
}

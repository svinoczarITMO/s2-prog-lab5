package commands

import data.Messages
import utils.CollectionManager
import utils.CommandManager
import utils.PrinterManager
import utils.Validator
import java.io.File

class ExecuteScript: Command {
    private val writeToConsole = PrinterManager()
    private val validator = Validator()
    private val commandManager: CommandManager = CommandManager()
    private val messages = Messages()
    private var depth = 0
    private var maxDepth = 8

    override fun execute(args: Array<String>, collectionManager: CollectionManager) {
        val argument = args[0]
        writeToConsole.writelnToConsole(messages.getMessage("script_start"))
        if (depth <= maxDepth) {
            val strings = File(argument).readLines()
            for (string in strings) {
                val command = string.split(" ")
                if (commandManager.getCommand(command[0]) != null) {
                    depth++
                    validator.validation(command.toTypedArray(), collectionManager)
                }
            }
        }
        depth--
        writeToConsole.writelnToConsole(messages.getMessage("script_end"))
    }
}
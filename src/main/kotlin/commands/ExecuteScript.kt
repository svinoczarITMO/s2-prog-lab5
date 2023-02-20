package commands

import data.Messages
import utils.CommandManager
import utils.PrinterManager
import java.io.File

class ExecuteScript: Command {
    private val writeToConsole = PrinterManager()
    private val commandManager: CommandManager = CommandManager()
    private val messages = Messages()
    private var depth = 0
    private var maxDepth = 8
    private val commands = commandManager.commands

    override fun execute(argument: String) {

        writeToConsole.writelnToConsole(messages.getMessage("script_start"))
        if (depth <= maxDepth) {
            val strings = File(argument).readLines()
            for (string in strings) {
                val command = string.split(" ")
                if (command[0] in commands) {
                    depth++
                    commands[command[0]]?.execute(command[0])
                } else if (command[0] == "execute_script") {
                   execute(argument)
                    depth++
                }
            }
        }
        depth--
        writeToConsole.writelnToConsole(messages.getMessage("script_end"))
    }
}
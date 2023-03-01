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
    private val maxDepth = 8
    private var depth = 0

    override fun execute(arg: Array<*>, collectionManager: CollectionManager) {

        val scriptFile = File(arg[0] as String)
        writeToConsole.writelnToConsole(messages.getMessage("script_start"))
        println(depth.toString() + "\n" + maxDepth.toString())
        if (depth <= maxDepth) {
            val strings = scriptFile.readLines()
            for (string in strings) {
                var new_args = string.split(" ")
                val command = commandManager.getCommand(new_args[0])
                new_args = new_args.slice(1 until new_args.size)
                depth += 1
                command?.execute(new_args.toTypedArray(), collectionManager)
                }
        } else {
            writeToConsole.writelnToConsole(messages.getMessage("recurision"))
        }
        depth -= 1
        writeToConsole.writelnToConsole(messages.getMessage("script_end"))
    }
}
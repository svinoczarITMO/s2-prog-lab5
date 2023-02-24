package utils

import commands.ExecuteScript
import commands.History

class Validator {
    val executeScript = ExecuteScript()
    val history = History()
    val loader = Loader()
    val writeToConsole = PrinterManager()
    val commandManager = CommandManager()
    val commands = commandManager.commands + mapOf("execute_script" to executeScript)

    fun validation (args: Array<String>, collectionManager: CollectionManager) {
        val command = commands[args[0]]
        val arguments = args.slice(1 until args.size).toTypedArray()
        history.writeInBuffer(args[0])
        command?.execute(arguments, collectionManager)
    }
}


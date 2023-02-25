package utils

import commands.ExecuteScript
import commands.History

class Validator {
    private val history = History()
    private val loader = Loader()
    private val writeToConsole = PrinterManager()
    private val commandManager = CommandManager()
    val commands = commandManager.commands //+ mapOf("execute_script" to executeScript)

    fun validation (args: Array<String>, collectionManager: CollectionManager) {
        val executeScript = ExecuteScript()
        val command = commands[args[0]]
        val arguments = args.slice(1 until args.size).toTypedArray()
        history.writeInBuffer(args[0])
        if (command != executeScript) {
            command?.execute(arguments, collectionManager)
        } else {executeScript.execute(arguments, collectionManager)}
    }
}


package commands

import data.Messages
import utils.CollectionManager
import utils.CommandManager
import utils.PrinterManager
import utils.Validator
import java.io.File
import java.io.FileNotFoundException

class ExecuteScript: Command <String> {
    private val writeToConsole = PrinterManager()
    private val validator = Validator()
    private val commandManager: CommandManager = CommandManager()
    private val messages = Messages()
    private val maxDepth = 8
    private var depth = 0
    private var scriptFile = File("")

    override fun execute(arg: Array<Any>, collectionManager: CollectionManager) {
        try {
            scriptFile = File(arg[0] as String)
        } catch (e: FileNotFoundException) {
            writeToConsole.writelnToConsole("Указанный файл не найден")
            return
        }

        try {
            if (depth <= maxDepth) {
                val strings = scriptFile.readLines()
                writeToConsole.writelnToConsole(messages.getMessage("script_start"))
                for (string in strings) {
                    val new_args = string.split(" ")
                    if (new_args[0] == "execute_script") {
                        depth += 1
                        execute(new_args.slice(1 until new_args.size).toTypedArray(), collectionManager)
                    } else {
                        validator.validation(new_args.toTypedArray(), collectionManager)
                    }
                }
            } else {
                writeToConsole.writelnToConsole(messages.getMessage("recurision"))

            }
        } catch (e: FileNotFoundException) {
            writeToConsole.writelnToConsole("Указанный файл не найден")
            return
        }
        depth -= 1
        if (depth == 0) {
            writeToConsole.writelnToConsole(messages.getMessage("script_end"))
        }
    }
}
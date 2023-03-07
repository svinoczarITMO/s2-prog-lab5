package commands

import data.Messages
import org.jetbrains.kotlin.konan.file.File
import utils.CollectionManager
import utils.CommandManager
import utils.PrinterManager
import utils.Validator
import java.io.FileNotFoundException

/**
 * Executes script from inputed path to file.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class ExecuteScript: Command <String> {
    private val writeToConsole = PrinterManager()
    private val validator = Validator()
    private val commandManager: CommandManager = CommandManager()
    private val messages = Messages()
    private val maxDepth = 8
    private var depth = 0
    private var scriptFile = File("")

    override fun execute(args: Array<Any>, collectionManager: CollectionManager) {
        try {
            scriptFile = File(args[0] as String)
        } catch (e: FileNotFoundException) {
            writeToConsole.writelnInConsole("Указанный файл не найден")
            return
        }

        try {
            if (depth <= maxDepth) {
                val strings = scriptFile.readStrings()
                writeToConsole.writelnInConsole(messages.getMessage("script_start"))
                for (string in strings) {
                    val newArgs = string.split(" ")
                    if (newArgs[0] == "execute_script") {
                        depth += 1
                        execute(newArgs.slice(1 until newArgs.size).toTypedArray(), collectionManager)
                    } else {
                        validator.validation(newArgs.toTypedArray(), collectionManager)
                    }
                }
            } else {
                writeToConsole.writelnInConsole(messages.getMessage("recurision"))

            }
        } catch (e: FileNotFoundException) {
            writeToConsole.writelnInConsole("Указанный файл не найден")
            return
        }
        depth -= 1
        if (depth == 0) {
            writeToConsole.writelnInConsole(messages.getMessage("script_end"))
        }
    }
}
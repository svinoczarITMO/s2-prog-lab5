package utils

import data.Color
import data.Messages
import java.util.*

/**
 * Validates and handles commands and their arguments before executing.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Validator {
    private val commandManager = CommandManager()
    private val commandBuffer = LinkedList<String>()
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    /**
     * Validates arguments and starts command.
     *
     * @param args unchecked raw arguments.
     * @param collectionManager instance of Collection Manager.
     */
    fun validation(args: Array<String>, collectionManager: CollectionManager, flag: String) {
        val command = commandManager.getCommand(args[0])
        val invalidArguments = args.slice(1 until args.size).toTypedArray()

        if (commandBuffer.size == 7) {
            commandBuffer.pop()
            commandBuffer.add(args[0])
        } else {
            commandBuffer.add(args[0])
        }
        val validArgument = selector(args[0], invalidArguments + flag)?.toArray()
        try {
            command?.execute(validArgument!!, collectionManager)
        } catch (e: NullPointerException) {
            return
        }
    }

    /**
     * Validates what is command's type, handles invalid arguments and returns them.
     *
     * @param command name of command.
     * @param invalidArguments unchecked raw arguments.
     * @return valid arguments as ArrayList<Any>?
     */
    private fun selector(command: String, invalidArguments: Array<String>): ArrayList<Any>? {
        val validArgument = arrayListOf<Any>()

        val typeEmpty = arrayOf(
            "print", "fadd",
            "help", "info", "show",
            "clear", "save", "exit", "remove_first",
            "reorder", "min_by_weight", "group_counting_by_nationality"
        )
        val typeInt = arrayOf("remove_by_id", "get")
        val typeString = arrayOf("add", "update", "execute_script")
        val typeColor = arrayOf("count_by_hair_color")
        val typeArrays = arrayOf("change_collection", "history")
        when (command) {

            in typeEmpty -> {
                return validArgument
            }
            in typeString -> {
                invalidArguments.forEach {validArgument.add(it)}
                return validArgument
            }
            in typeInt -> {
                try {
                    validArgument.add(invalidArguments[0].toInt())
                    return validArgument
                } catch (e: NumberFormatException) {
                    writeToConsole.writelnInConsole(message.getMessage("invalid argument"))
                } catch (e: ArrayIndexOutOfBoundsException) {
                    writeToConsole.writelnInConsole(message.getMessage("invalid argument"))
                }

            }
            in typeColor -> {
                try {
                    validArgument.add(Color.valueOf(invalidArguments[0].uppercase()))
                    return validArgument
                } catch (e: IllegalArgumentException) {
                    writeToConsole.writelnInConsole(message.getMessage("invalid argument"))
                    return null
                } catch (e: ArrayIndexOutOfBoundsException) {
                    writeToConsole.writelnInConsole(message.getMessage("invalid argument"))
                    return null
                }
            }
            in typeArrays -> {
                try {
                    validArgument.add(commandBuffer.toList())
                    return validArgument
                } catch (e: NumberFormatException) {
                    writeToConsole.writelnInConsole(message.getMessage("invalid argument"))
                }
            }
        }
        return arrayListOf()
    }

    fun explorer (path: String?): String {
        var pathToScriptFile = ""
        if (path != null) {
            pathToScriptFile = path
        }
        return pathToScriptFile
    }
}
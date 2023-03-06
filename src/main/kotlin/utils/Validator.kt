package utils

import data.Color
import data.Messages
import java.util.*

class Validator {
    private val commandManager = CommandManager()
    private val commandBuffer = LinkedList<String>()
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    fun selector(command: String, invalidArguments: Array<String>): ArrayList<Any>? {
        var validArgument = arrayListOf<Any>()

        val typeEmpty = arrayOf(
            "print", "fadd",
            "help", "info", "show", "add",
            "clear", "save", "exit", "remove_first",
            "reorder", "min_by_weight", "group_counting_by_nationality"
        )
        val typeInt = arrayOf("update", "remove_by_id", "get")
        val typeString = arrayOf("execute_script")
        val typeColor = arrayOf("count_by_hair_color")
        val typeArrays = arrayOf("change_collection", "history")
        when (command) {

            in typeEmpty -> {
                return validArgument
            }
            in typeString -> {
                validArgument.add(invalidArguments[0])
                return validArgument
            }
            in typeInt -> {
                try {
                    validArgument.add(invalidArguments[0].toInt())
                    return validArgument
                } catch (e: NumberFormatException) {
                    writeToConsole.writelnToConsole(message.getMessage("invalid argument"))
                } catch (e: ArrayIndexOutOfBoundsException) {
                    writeToConsole.writelnToConsole(message.getMessage("invalid argument"))
                }

            }
            in typeColor -> {
                try {
                    validArgument.add(Color.valueOf(invalidArguments[0].uppercase()))
                    return validArgument
                } catch (e: IllegalArgumentException) {
                    writeToConsole.writelnToConsole(message.getMessage("invalid argument"))
                    return null
                } catch (e: ArrayIndexOutOfBoundsException) {
                    writeToConsole.writelnToConsole(message.getMessage("invalid argument"))
                    return null
                }
            }
            in typeArrays -> {
                try {
                    validArgument.add(commandBuffer.toList())
                    return validArgument
            } catch (e: NumberFormatException) {
                writeToConsole.writelnToConsole(message.getMessage("invalid argument"))
                }
            }
        }
        return arrayListOf()
    }

    fun validation(args: Array<String>, collectionManager: CollectionManager) {
        val command = commandManager.getCommand(args[0])
        val invalidArguments = args.slice(1 until args.size).toTypedArray()

        if (commandBuffer.size == 7) {
            commandBuffer.pop()
            commandBuffer.add(args[0])
        } else {
            commandBuffer.add(args[0])
        }
        val validArgument = selector(args[0], invalidArguments)?.toArray()
        try {
            command?.execute(validArgument!!, collectionManager)
        } catch (e: NullPointerException) {
            return
        }
    }
}
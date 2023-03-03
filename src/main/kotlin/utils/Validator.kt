package utils

import data.Color
import data.Messages
import java.util.*

class Validator {
    private val commandManager = CommandManager()
    private val commandBuffer = LinkedList<String>()
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    fun selector(command: String, invalidArguments: Array<String>): ArrayList<Any> {
        val validArgument = arrayListOf<Any>()

        val voids = arrayOf(
            "print", "fadd",
            "help", "info", "show", "add",
            "clear", "save", "exit", "remove_first",
            "reorder", "min_by_weight", "group_counting_by_nationality"
        )
        val ints = arrayOf("update", "remove_by_id", "get")
        val strings = arrayOf("execute_script")
        val colors = arrayOf("count_by_hair_color")
        val arrays = arrayOf("change_collection", "history")
        when (command) {

            in voids -> return validArgument

            in strings -> {
                validArgument.add(invalidArguments[0])
                return validArgument
            }

            in ints -> {
                try {
                    validArgument.add(invalidArguments[0].toInt())
                    return validArgument
                } catch (e: NumberFormatException) {
                    writeToConsole.writelnToConsole(message.getMessage("invalid argument"))
                } catch (e: ArrayIndexOutOfBoundsException) {
                    writeToConsole.writelnToConsole(message.getMessage("invalid argument"))
                }

            }

            in colors -> {
                validArgument.add(Color.valueOf(invalidArguments[0].uppercase()))
                return validArgument
            }

            in arrays -> {
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
//        catch (e: NumberFormatException) {
//            writeToConsole.writelnToConsole("Введенно недопустимое значение аргумента.")
//            return arrayListOf()
//        }


    fun validation(args: Array<String>, collectionManager: CollectionManager) {
        val command = commandManager.getCommand(args[0])
        val invalidArguments = args.slice(1 until args.size).toTypedArray()

        if (commandBuffer.size == 7) {
            commandBuffer.pop()
            commandBuffer.add(args[0])
        } else {
            commandBuffer.add(args[0])
        }
        val validArgument = selector(args[0], invalidArguments).toArray()
        command?.execute(validArgument, collectionManager)
    }
}
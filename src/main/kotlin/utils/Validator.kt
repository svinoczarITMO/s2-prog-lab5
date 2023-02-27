package utils

import data.Color
import java.util.*

class Validator {
    private val commandManager = CommandManager()
    private val commandBuffer = LinkedList<String>()

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
                validArgument.add(invalidArguments[0].toInt())
                return validArgument
            }
            in colors -> {
                validArgument.add(Color.valueOf(invalidArguments[0].uppercase()))
                return validArgument
            }

            in arrays -> {
//                validArgument.add(invalidArguments)
                validArgument.add(commandBuffer.toList())
                return  validArgument
            }
        }
        return validArgument
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
        val validArgument = selector(args[0], invalidArguments).toArray()
        command?.execute(validArgument, collectionManager)
    }
}
package utils

import data.Color
import data.Messages
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.*

/**
 * Validates and handles commands and their arguments before executing.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Validator: KoinComponent{
    private val collectionManager: CollectionManager by inject()
    private val commandManager: CommandManager by inject()
    private val messages: Messages by inject()
    private val commandBuffer = LinkedList<String>()

    /**
     * Validates arguments and starts command.
     *
     * @param args unchecked raw arguments.
     * @param collectionManager instance of Collection Manager.
     */
//    fun validate(args: Array<String>) {
//        val command = commandManager.getCommand(args[0])
//        val invalidArguments = args.slice(1 until args.size).toTypedArray()
//
//        if (commandBuffer.size == 7) {
//            commandBuffer.pop()
//            commandBuffer.add(args[0])
//        } else {
//            commandBuffer.add(args[0])
//        }
//        val validArgument = selector(args[0], invalidArguments + flag)?.toArray()
//        try {
////            command?.execute(validArgument!!, collectionManager)
//        } catch (e: NullPointerException) {
//            return
//        }
//    }


    fun validate (args: Array<Any>) {
        val commandName = args[0] as String
        val mapOfArgs = mutableMapOf<String, Any?>()
        val arguments = args.slice(1 until args.size)
        println(arguments)

        if (commandBuffer.size == 7) {
            commandBuffer.pop()
            commandBuffer.add(commandName)
        } else {
            commandBuffer.add(commandName)
        }

        when (commandName){
            "add" -> {
                mapOfArgs["rawParams"] = if (arguments[1] != "main") arguments[0] else arrayListOf(null)
                mapOfArgs["flag"] = arguments[1]
            }
            "update" -> {
                mapOfArgs["rawParams"] = if (arguments[1] != "main") arguments[0] else arrayListOf(null)
                mapOfArgs["flag"] = arguments[1]
            }
            "execute_script" -> {
                mapOfArgs["path"] = arguments[0]
            }
            "history" -> {
                mapOfArgs["buffer"] = commandBuffer
            }
            "remove_by_id" -> {
                mapOfArgs["id"] = arguments[0]
            }
            "get" -> {
                mapOfArgs["id"] = arguments[0]
            }
            "count_by_hair_color" -> {
                mapOfArgs["color"] = Color.valueOf((arguments[0] as String).uppercase())
            }
            "clear" -> {
                mapOfArgs["none"] = null
            }
            "exit" -> {
                mapOfArgs["none"] = null
            }
            "group_counting_by_nationality" -> {
                mapOfArgs["none"] = null
            }
            "help" -> {
                mapOfArgs["none"] = null
            }
            "info" -> {
                mapOfArgs["none"] = null
            }
            "min_by_weight" -> {
                mapOfArgs["none"] = null
            }
            "remove_first" -> {
                mapOfArgs["none"] = null
            }
            "reorder" -> {
                mapOfArgs["none"] = null
            }
            "save" -> {
                mapOfArgs["none"] = null
            }
            "show" -> {
                mapOfArgs["none"] = null
            }
            "fadd" -> {
                mapOfArgs["none"] = null
            }
            "print" -> {
                mapOfArgs["none"] = null
            }
        }
        val command = commandManager.getCommand(commandName)
        try {
            command?.execute(mapOfArgs)
        } catch (e: NullPointerException) {
            return
        }
    }




//    /**
//     * Validates what is command's type, handles invalid arguments and returns them.
//     *
//     * @param command name of command.
//     * @param invalidArguments unchecked raw arguments.
//     * @return valid arguments as ArrayList<Any>?
//     */
//    private fun selector(command: String, invalidArguments: Array<String>): ArrayList<Any>? {
//        val validArgument = arrayListOf<Any>()
//
//        val typeEmpty = arrayOf(
//            "print", "fadd",
//            "help", "info", "show",
//            "clear", "save", "exit", "remove_first",
//            "reorder", "min_by_weight", "group_counting_by_nationality"
//        )
//        val typeInt = arrayOf("remove_by_id", "get")
//        val typeString = arrayOf("add", "update", "execute_script")
//        val typeColor = arrayOf("count_by_hair_color")
//        val typeArrays = arrayOf("change_collection", "history")
//
//        when (command) {
//            in typeEmpty -> {
//                return validArgument
//            }
//            in typeString -> {
//                invalidArguments.forEach {validArgument.add(it)}
//                return validArgument
//            }
//            in typeInt -> {
//                try {
//                    validArgument.add(invalidArguments[0].toInt())
//                    return validArgument
//                } catch (e: NumberFormatException) {
//                    writeToConsole.linesInConsole(message.getMessage("invalid argument"))
//                } catch (e: ArrayIndexOutOfBoundsException) {
//                    writeToConsole.linesInConsole(message.getMessage("invalid argument"))
//                }
//
//
//            }
//            in typeColor -> {
//                try {
//                    validArgument.add(Color.valueOf(invalidArguments[0].uppercase()))
//                    return validArgument
//                } catch (e: IllegalArgumentException) {
//                    writeToConsole.linesInConsole(message.getMessage("invalid argument"))
//                    return null
//                } catch (e: ArrayIndexOutOfBoundsException) {
//                    writeToConsole.linesInConsole(message.getMessage("invalid argument"))
//                    return null
//                }
//            }
//            in typeArrays -> {
//                try {
//                    validArgument.add(commandBuffer.toList())
//                    return validArgument
//                } catch (e: NumberFormatException) {
//                    writeToConsole.linesInConsole(message.getMessage("invalid argument"))
//                }
//            }
//        }
//        return arrayListOf()
//    }

    fun explorer (path: String?): String {
        var pathToScriptFile = ""
        if (path != null) {
            pathToScriptFile = path
        }
        return pathToScriptFile
    }

    fun flagpole (flag: String): Boolean {
        return flag=="main"
    }
}
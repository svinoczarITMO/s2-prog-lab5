package utils

import commands.Command
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
    private val message: Messages by inject()
    private val write: PrinterManager by inject()
    private val commandBuffer = LinkedList<String>()

    /**
     * Validates arguments and starts command.
     *
     * @param args unchecked raw arguments.
     * @param collectionManager instance of Collection Manager.
     */
    fun validate (args: Array<Any?>) {
        val commandName = args[0] as String
        val mapOfArgs = mutableMapOf<String, Any?>()
        val arguments = args.slice(1 until args.size)

        val noArgs = arrayOf(
            "print", "fadd",
            "help", "info", "show", "history",
            "clear", "save", "exit", "remove_first",
            "reorder", "min_by_weight", "group_counting_by_nationality")
        val oneArg = arrayOf(
            "remove_by_id", "get",
            "count_by_hair_color", "execute_script", "change_collection"
        )
        val newObj = arrayOf(
            "add"
        )
        val argAndObj = arrayOf(
            "update"
        )

        val oneArgCommands = mapOf<String, String>(
            "execute_script" to "path",
            "remove_by_id" to "id",
            "get" to "id",
            "history" to "buffer",
            "count_by_hair_color" to "color"
        )

        if (commandBuffer.size == 7) {
            commandBuffer.pop()
            commandBuffer.add(commandName)
        } else {
            commandBuffer.add(commandName)
        }

        mapOfArgs["buffer"] = commandBuffer

        try {
            when (commandName) {
                in noArgs -> {
                    mapOfArgs["none"] = null
                }

                in oneArg -> {
                    val name = oneArgCommands[commandName]
                    mapOfArgs["$name"] = extraValidation(name!!, arguments)
                }

                in newObj -> {
                    mapOfArgs["flag"] = arguments[0]
                    mapOfArgs["path"] = if (arguments[0] != "main") arguments[1] else ""
                }

                in argAndObj -> {
                    mapOfArgs["elementId"] = arguments[0].toString().toInt()
                    mapOfArgs["flag"] = arguments[1]
                    mapOfArgs["path"] = if (arguments[1] != "main") arguments[2] else ""
                }
            }
        } catch (e: NumberFormatException) {
            write.linesInConsole(message.getMessage("InvalidArgument"))
            return
        }

//        when (commandName){
//            "add" -> {
//                mapOfArgs["flag"] = arguments[0]
//                mapOfArgs["path"] = if (arguments[0] != "main") arguments[1] else ""
//            }
//            "update" -> {
//                mapOfArgs["elementId"] = arguments[0].toString().toInt()
//                mapOfArgs["flag"] = arguments[1]
//                mapOfArgs["path"] = if (arguments[1] != "main") arguments[2] else ""
//            }
//            "execute_script" -> {
//                mapOfArgs["path"] = arguments[0]
//            }
//            "history" -> {
//                mapOfArgs["buffer"] = commandBuffer
//            }
//            "remove_by_id" -> {
//                mapOfArgs["id"] = arguments[0].toString().toInt()
//            }
//            "get" -> {
//                mapOfArgs["id"] = arguments[0].toString().toInt()
//            }
//            "count_by_hair_color" -> {
//                mapOfArgs["color"] = Color.valueOf((arguments[0] as String).uppercase())
//            }
//            "clear" -> {
//                mapOfArgs["none"] = null
//            }
//            "exit" -> {
//                mapOfArgs["none"] = null
//            }
//            "group_counting_by_nationality" -> {
//                mapOfArgs["none"] = null
//            }
//            "help" -> {
//                mapOfArgs["none"] = null
//            }
//            "info" -> {
//                mapOfArgs["none"] = null
//            }
//            "min_by_weight" -> {
//                mapOfArgs["none"] = null
//            }
//            "remove_first" -> {
//                mapOfArgs["none"] = null
//            }
//            "reorder" -> {
//                mapOfArgs["none"] = null
//            }
//            "save" -> {
//                mapOfArgs["none"] = null
//            }
//            "show" -> {
//                mapOfArgs["none"] = null
//            }
//            "fadd" -> {
//                mapOfArgs["none"] = null
//            }
//            "print" -> {
//                mapOfArgs["none"] = null
//            }
//        }
        val command = commandManager.getCommand("commands", commandName, "Command")
        execute(command, mapOfArgs)
    }

    fun execute (command: Command?, args: Map<String, Any?>) {
        try {
            command?.execute(args)
        } catch (e: NullPointerException) {
            return
        }
    }

    fun extraValidation (name: String, arguments: List<Any?>): Any {
        when (name) {
            "path" -> return arguments[0].toString()
            "color" -> return Color.valueOf((arguments[0].toString()).uppercase())
            "id" -> return arguments[0].toString().toInt()
        }
        return 0
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
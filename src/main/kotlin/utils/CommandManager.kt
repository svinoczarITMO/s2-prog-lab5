package utils

import commands.*
import commands.dev.FastAdd
import commands.dev.GetElement
import commands.dev.PrintCollection
import data.Color

class CommandManager {
        fun getCommand(command: String): Command<out Any>? {
                val help: Help = Help()
                val info: Info = Info()
                val show: Show = Show()
                val add: Add = Add()
                val update: Update = Update()
                val removeById: RemoveByID = RemoveByID()
                val executeScript = ExecuteScript()
                val minByWeight = MinByWeight()
                val history = History()
                val clear: Clear = Clear()
                val save: Save = Save()
                val exit: Exit = Exit()
                val removeFirst: RemoveFirst = RemoveFirst()
                val reorder: Reorder = Reorder()
                val groupCountingByNationality: GroupCountingByNationality = GroupCountingByNationality()
                val countByHairColor: CountByHairColor = CountByHairColor()
                val fastAdd: FastAdd = FastAdd()
                val printCollection: PrintCollection = PrintCollection()
                val getElement: GetElement = GetElement()

                val commands = mapOf(
                        "help" to help,
                        "info" to info,
                        "show" to show,
                        "add" to add,
                        "update" to update,
                        "remove_by_id" to removeById,
                        "clear" to clear,
                        "save" to save,
                        "exit" to exit,
                        "remove_first" to removeFirst,
                        "reorder" to reorder,
                        "group_counting_by_nationality" to groupCountingByNationality,
                        "count_by_hair_color" to countByHairColor,
                        "fadd" to fastAdd,
                        "print" to printCollection,
                        "get" to getElement,
                        "execute_script" to executeScript,
                        "history" to history,
                        "min_by_weight" to minByWeight
                )

                return commands[command]
        }

        fun selector(command: String, arguments: Array<String>): Any {
                val voids = arrayOf(
                        "help", "info", "show", "add", "clear", "save", "exit", "remove_first",
                        "reorder", "min_by_weight", "group_counting_by_nationality"
                )
                val ints = arrayOf("update", "remove_by_id")
                val strings = arrayOf("execute_script")
                val colors = arrayOf("count_by_hair_color")
                val arrays = arrayOf("change_collection","history")

                val singleArg = arguments[0]

                when (command) {
                        in voids -> return 0
                        in ints -> return singleArg.toInt()
                        in strings -> return singleArg
                        in colors -> return Color.valueOf(singleArg.uppercase())
                        in arrays -> return arguments
                }
                return 0
        }
}

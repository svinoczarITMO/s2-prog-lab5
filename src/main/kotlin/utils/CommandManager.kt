package utils

import commands.*
import commands.dev.FastAdd
import commands.dev.GetElement
import commands.dev.PrintCollection

class CommandManager{
        private val help: Help = Help()
        private val info: Info = Info()
        private val show: Show = Show()
        private val add: Add = Add()
        private val update: Update = Update()
        private val removeById: RemoveByID = RemoveByID()
        private val clear: Clear = Clear()
        private val save: Save = Save()
        private val exit: Exit = Exit()
        private val removeFirst: RemoveFirst = RemoveFirst()
        private val reorder: Reorder = Reorder()
        private val history: History = History()
        private val minByWeight: MinByWeight = MinByWeight()
        private val groupCountingByNationality: GroupCountingByNationality = GroupCountingByNationality()
        private val countByHairColor: CountByHairColor = CountByHairColor()
        private val fastAdd: FastAdd = FastAdd()
        private val printCollection: PrintCollection = PrintCollection()
        private val getElement: GetElement = GetElement()

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
                "history" to history,
                "min_by_weight" to minByWeight,
                "group_counting_by_nationality" to groupCountingByNationality,
                "count_by_hair_color" to countByHairColor,
                "fadd" to fastAdd,
                "print" to printCollection,
                "get" to getElement)
}
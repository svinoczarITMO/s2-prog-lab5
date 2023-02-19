
import commands.*
import commands.dev.FastAdd
import commands.dev.GetElement
import commands.dev.PrintCollection
import utils.Loader
import utils.PrinterManager

fun main() {
    val loader: Loader = Loader()
    val help: Help = Help()
    val info: Info = Info()
    val show: Show = Show()
    val add: Add = Add()
    val update: Update = Update()
    val removeById: RemoveByID = RemoveByID()
    val clear: Clear = Clear()
    val save: Save = Save()
    val executeScript: ExecuteScript = ExecuteScript()
    val exit: Exit = Exit()
    val removeFirst: RemoveFirst = RemoveFirst()
    val reorder: Reorder = Reorder()
    val history: History = History()
    val minByWeight: MinByWeight = MinByWeight()
    val groupCountingByNationality:GroupCountingByNationality = GroupCountingByNationality()
    val countByHairColor: CountByHairColor = CountByHairColor()
    val fastAdd: FastAdd = FastAdd()
    val printCollection: PrintCollection = PrintCollection()
    val getElement: GetElement = GetElement()
    val writeToConsole: PrinterManager = PrinterManager()
    val commands = mapOf<String, Command>(
        "help" to help,
        "info" to info,
        "show" to show,
        "add" to add,
        "update" to update,
        "remove_by_id" to removeById,
        "clear" to clear,
        "save" to save,
        "execute_script" to executeScript,
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

    loader.loadFromFile()

    while (true){
        writeToConsole.writeToConsole("$")
        val readFromConsole = (readln().lowercase() + " ?").split(" ")
        if (readFromConsole[0] in commands) {
            val command: Command? = commands.get(readFromConsole[0])
            if (command != null) {
                History.writeInBuffer(command.toString())
                command.execute(readFromConsole[1])
            }
        } else {
            writeToConsole.writelnToConsole("Введена неверная команда. Используйте help для вывода списка команд.")
        }
    }
}

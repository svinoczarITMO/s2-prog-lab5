
import commands.*
import utils.PrinterManager

fun main() {
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
    val writeToConsole: PrinterManager = PrinterManager()

    val commands = mapOf<String, Command>(
        "help" to Help(),
        "info" to Info(),
        "show" to Show(),
        "add" to Add(),
        "update" to Update(),
        "remove_by_id" to RemoveByID(),
        "clear" to Clear(),
        "save" to Save(),
        "execute_script" to ExecuteScript(),
        "exit" to Exit(),
        "remove_first" to RemoveFirst(),
        "reorder" to Reorder(),
        "history" to History(),
        "min_by_weight" to MinByWeight(),
        "group_counting_by_nationality" to GroupCountingByNationality(),
        "count_by_hair_color" to CountByHairColor())

    while (true) {
        writeToConsole.writeToConsole("$")
        val readFromConsole = (readln().lowercase() + " ?").split(" ")
        if (readFromConsole[0] in commands) {
            val command: Command? = commands.get(readFromConsole[0])
            if (command != null) {
                command.execute(readFromConsole[1])
            }
        } else {
            writeToConsole.writelnToConsole("Введена неверная команда. Используйте help для вывода списка команд.")
        }
    }
}
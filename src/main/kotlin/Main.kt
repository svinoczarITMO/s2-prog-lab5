import commands.*
import controllers.CollectionController
import controllers.CommandController

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

    val collectionController: CollectionController = CollectionController()
    val commandController: CommandController = CommandController()

    save.readFromFile()
    while (true){
        val command: List<String> = readln().lowercase().split(" ")
        history.writeInBuffer(command[0])
        when (command[0]) {
            "/print" -> commandController.prnt()
            "/get" -> commandController.get((command[1]).toInt())
            "/fadd" -> commandController.fadd()

            "help" -> help.help()
            "info" -> info.info()
            "show" -> show.printAllElementsAsString()
            "add" -> add.addNewElement()
            "update" -> update.updateElement((command[1]).toInt())
            "remove_by_id" -> collectionController.removeById((command[1]).toInt())
            "clear" -> collectionController.clear()
            "save" -> save.writeInFile()
            "execute_script" -> commandController.executeScript(command[1]) //TODO: реализовать
            "exit" -> commandController.exit()
            "remove_first" -> collectionController.removeFirst()
            "reorder" -> collectionController.reorder()
            "history" -> history.printHistory()
            "min_by_weight" -> minByWeight.minWeightElement()
            "group_counting_by_nationality" -> groupCountingByNationality.groupByNationality()
            "count_by_hair_color" -> countByHairColor.countByHairColor(command[1])

            else -> println("Такой команды не существует.")

        }
    }
}
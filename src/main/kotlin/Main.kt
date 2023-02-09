import commands.*

fun main() {
    Save.readFromFile()
    while (true){
        val command: List<String> = readln().lowercase().split(" ")
        History.writeInBuffer(command[0])
        when (command[0]) {
            "/print" -> CommandController.prnt()
            "/get" -> CommandController.get((command[1]).toInt())
            "/fadd" -> CommandController.fadd()

            "help" -> Help.help()
            "info" -> CollectionController.printInfo()
            "show" -> Show.printAllElementsAsString()
            "add" -> Add.addNewElement()
            "update" -> Update.updateElement((command[1]).toInt())
            "remove_by_id" -> CollectionController.removeById((command[1]).toInt())
            "clear" -> CollectionController.clear()
            "save" -> Save.writeInFile()
            "execute_script" -> CommandController.executeScript(command[1]) //TODO: реализовать
            "exit" -> CommandController.exit()
            "remove_first" -> CollectionController.removeFirst()
            "reorder" -> CollectionController.reorder()
            "history" -> History.printHistory()
            "min_by_weight" -> MinByWeight.minWeightElement()
            "group_counting_by_nationality" -> CommandController.groupCountingByNationality() //TODO: реализовать
            "count_by_hair_color" -> CountByHairColor.countByHairColor(command[1]) //TODO: реализовать

            else -> println("Такой команды не существует.")

        }
    }
}
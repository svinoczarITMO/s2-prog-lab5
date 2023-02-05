import kotlin.system.exitProcess

fun main(args: Array<String>) {

    while (true){
        val command: List<String> = readln().split(" ")
        when (command[0]) {
            "add_el" -> CommandController.addEl()
            "help" -> CommandController.help()
            "info" -> CommandController.info()
            "show" -> CommandController.show()
            "insert" -> CommandController.insert(command[1])
            "update" -> CommandController.update((command[1]).toInt())
            "remove_key" -> CommandController.removeKey(command[1])
            "clear" -> CommandController.clear()
            "save" -> CommandController.save()
            "execute_script" -> CommandController.executeScript(command[1])
            "exit" -> CommandController.exit()
            "remove_greater" -> CommandController.removeGreater(command[1])
            "replace_if_lower" -> CommandController.replaceIfLower(command[1])
            "remove_greater_key" -> CommandController.removeGreaterKey(command[1])
            "count_greater_than_description" -> CommandController.countGreaterThanDescription(command[1])
            "filter_less_than_genre" -> CommandController.filterLessThanGenre(command[1])
            "print_field_descending_number_of_participants" -> CommandController.printFieldDescendingNumberOfParticipants()



            else -> println("Такой команды не существует.")

        }
        exitProcess(0)
    }
}
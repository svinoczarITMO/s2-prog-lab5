import kotlin.system.exitProcess

fun main(args: Array<String>) {

    while (true){
        val command: List<String> = readln().split(" ")
        when (command[0]) {
            "help" -> CommandController.help()
            "info" -> CommandController.info()
            "show" -> CommandController.show()
            "add" -> CommandController.add()
            "update" -> CommandController.update((command[1]).toInt())
            "remove_by_id" -> CommandController.removeById((command[1]).toInt())
            "clear" -> CommandController.clear()
            "save" -> CommandController.save()
            "execute_script" -> CommandController.executeScript(command[1])
            "exit" -> CommandController.exit()
            "remove_first" -> CommandController.removeFirst()
            "recorder" -> CommandController.recorder()
            "history" -> CommandController.history()
            "min_by_weight" -> CommandController.minByWeight()
            "group_counting_by_nationality" -> CommandController.groupCountingByNationality()
            "count_by_hair_color" -> CommandController.countByHairColor()



            else -> println("Такой команды не существует.")

        }
        exitProcess(0)
    }
}
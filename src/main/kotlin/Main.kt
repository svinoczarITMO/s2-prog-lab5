import kotlin.system.exitProcess

fun main(args: Array<String>) {

    while (true){
        val command: List<String> = readln().split(" ")
        when (command[0]) {
            "help" -> CommandController.help()
            "info" -> CommandController.info()
            "show" -> CommandController.show()
            "insert" -> CommandController.insert(command[1])
            "update" -> CommandController.update((command[1]).toInt())


            else -> println("Такой команды не существует.")

        }
        exitProcess(0)
    }
}
import commands.Command
import commands.ExecuteScript
import commands.History
import utils.CommandManager
import utils.Loader
import utils.PrinterManager


fun main() {
    val executeScript = ExecuteScript()
    val loader = Loader()
    val writeToConsole = PrinterManager()
    val commandManager = CommandManager()
    val commands = commandManager.commands + mapOf("execute_script" to executeScript)

    loader.loadFromFile()

    while (true){
        writeToConsole.writeToConsole("$")
        val readFromConsole = (readln().lowercase() + " ?").split(" ")
        if (readFromConsole[0] in commands) {
            val command: Command? = commands[readFromConsole[0]]
            if (command != null) {
                History.writeInBuffer(command.toString())
                command.execute(readFromConsole[1])
            }
        } else {
            writeToConsole.writelnToConsole("Введена неверная команда. Используйте help для вывода списка команд.")
        }
    }

    //TODO: 1) Info
    //TODO: 2) Show
    //TODO: 3) MinByWeight
    //TODO: 4) CountByHairColor

}

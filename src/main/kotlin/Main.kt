
import commands.ExecuteScript
import data.Person
import utils.*
import java.util.*


fun main() {
    val collectionManager = CollectionManager()
    val validator = Validator()
    val executeScript = ExecuteScript()
    val loader = Loader()
    val writeToConsole = PrinterManager()
    val commandManager = CommandManager()
    val commands = commandManager.commands + mapOf("execute_script" to executeScript)

    var vector = Vector<Person>()

    loader.loadFromFile()

    while (true){
        writeToConsole.writeToConsole("$")
        val readFromConsole = (readln().lowercase() + " ?").split(" ")
        if (readFromConsole[0] in commands) {
            validator.validation(readFromConsole.toTypedArray(), collectionManager)
        } else {
            writeToConsole.writelnToConsole("Введена неверная команда. Используйте help для вывода списка команд.")
        }
    }

    //TODO: 1) Info (дата инициализации)
    //TODO: 2) Show ☻
    //TODO: 3) MinByWeight
    //TODO: 4) CountByHairColor ☻
    //TODO: 5) Обработка ошибок

}

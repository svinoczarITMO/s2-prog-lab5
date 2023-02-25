import commands.ExecuteScript
import commands.MinByWeight
import utils.*


fun main() {
    val collectionManager = CollectionManager()
    val validator = Validator()
    val minByWeight = MinByWeight()
    val executeScript = ExecuteScript()
    val loader = Loader()
    val logger = Logger()
    val writeToConsole = PrinterManager()
    val commandManager = CommandManager()
    val commands = commandManager.commands + mapOf("execute_script" to executeScript, "min_by_weight" to minByWeight)

    logger.initDate(collectionManager)
    loader.loadFromFile(collectionManager)

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
    //TODO: 2) History
    //TODO: 3) MinByWeight
    //TODO: 4) Обработка ошибок
}

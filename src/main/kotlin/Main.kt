
import utils.*


fun main() {
    val collectionManager = CollectionManager()
    val validator = Validator()
    val loader = Loader()
    val logger = Logger()
    val writeToConsole = PrinterManager()
    val commandManager = CommandManager()

    logger.initDate(collectionManager)
    loader.loadFromFile(collectionManager)

    while (true){
        writeToConsole.writeToConsole("$")
        val readFromConsole = (readln().lowercase()).split(" ")
        if (commandManager.getCommand(readFromConsole[0]) != null ){
            validator.validation(readFromConsole.toTypedArray(), collectionManager)
        } else {
            writeToConsole.writelnToConsole("Введена неверная команда. Используйте help для вывода списка команд.")
        }
    }
    //TODO: 2) History
    //TODO: 3) MinByWeight
    //TODO: 4) Обработка ошибок
    //TODO: 5) Новая команда
    //TODO: 6) переменная окружения
}

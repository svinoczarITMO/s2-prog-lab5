
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
    //TODO:------------------3)-Validator-----------------------------
    //TODO:------------------4)-переменная-окружения------------------
    //TODO:------------------5)-MinByWeight---------------------------

    //TODO: 7) Обработка ошибок
    //TODO: 6) !!!ExecuteScript!!!

    //TODO: 8) Новая команда

    //linked hash map
}

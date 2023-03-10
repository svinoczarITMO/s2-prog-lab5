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
        val flag = ::main.name
        writeToConsole.writeInConsole("> ")
        val readFromConsole = (readln().lowercase()).split(" ")
        if (commandManager.getCommand(readFromConsole[0]) != null ){
            validator.validation(readFromConsole.toTypedArray(), collectionManager, flag)
        } else {
            writeToConsole.writelnInConsole("Введена неверная команда. Используйте help для вывода списка команд.")
        }
    }
}
//DONE: 3) Validator
//DONE: 4) переменная-окружения
//DONE: 5) MinByWeight
//DONE: 6) ExecuteScript
//DONE: 7) Обработка 95% ошибок
//DONE: 8) ExecuteScript аргумент
//DONE: 9) update из файла
//DONE: 10) KOTLIN DOKKA 85%
//DONE: 11) add из файла

//TODO: 12) KOTLIN DOKKA + 15%

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
    //TODO:------------------3)-Validator-----------------------------
    //TODO:------------------4)-переменная-окружения------------------
    //TODO:------------------5)-MinByWeight---------------------------
    //TODO:------------------6)-ExecuteScript-------------------------
    //TODO:------------------7)-Обработка-95%-ошибок------------------
    //TODO:------------------10)-KOTLIN-DOKKA-98%---------------------
    //TODO:------------------11)-add-из-файла-------------------------

    //TODO: 8) ExecuteScript аргумент
    //TODO: 9) Новая команда
    //TODO: 12) update из файла


    //linked hash map
}

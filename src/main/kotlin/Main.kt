
import data.Messages
import di.notKoinModule
import org.koin.core.context.GlobalContext.startKoin
import utils.*


fun main() {
    startKoin {
        modules(notKoinModule)
    }

    val collectionManager = CollectionManager()
    val validator = Validator()
    val loader = Loader()
    val logger = Logger()
    val writeToConsole = PrinterManager()
    val commandManager = CommandManager()
    val message = Messages()

    logger.initDate(collectionManager)
    loader.load()

    while (true){
        val flag = ::main.name
        writeToConsole.inConsole("> ")
        val readFromConsole = (readln().lowercase()).split(" ").toMutableList()
        readFromConsole.add(flag)
        if (commandManager.getCommand("commands", readFromConsole[0], "Command") != null ){
            validator.validate(readFromConsole.toTypedArray())
        } else {
            writeToConsole.linesInConsole(message.getMessage("weird_command"))
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
//DONE: 12) Починить ExecuteScript
//DONE: 12.5) Дописать валидатор
//DONE: 13) Обработка ошибок в валидаторе
//DONE: 14) Дописать серриализацию
//DONE: 15) Починить Save и Load
//DONE: 16) CHANGE_COLLECTION ()


//TODO: 17) 10 юнит тестов
//TODO: 18) KOTLIN DOKKA
package commands

import utils.CollectionManager
import utils.Logger
import utils.PrinterManager


class Info: Command {
    private val writeToConsole = PrinterManager()
    private val logger = Logger()

    override fun execute(args: Array<String>, collectionManager: CollectionManager) {
        val typeArray = collectionManager::getVector.returnType.toString().split(".")
        val type = typeArray[2] + "." + typeArray[3]
        val size = collectionManager.getVector().size
        val initDate = logger.initDate(collectionManager)
        writeToConsole.writelnToConsole(
                    "Тип: " + type + "\n"
                    + "Размер: " + size + "\n"
                    + "Дата инициализации: " + initDate)
    }

}

package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager


class Info: Command {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(args: Array<String>, collectionManager: CollectionManager) {
        val type = collectionManager::getVector.returnType
        val size = collectionManager.getVector().size
        writeToConsole.writelnToConsole(
            type.toString().split(".")[2] + ", "
                    + "Размер: " + size + ", "
                    + "Дата инициализации: " + collectionManager.getVector().get(0).creationDate)
    }

}

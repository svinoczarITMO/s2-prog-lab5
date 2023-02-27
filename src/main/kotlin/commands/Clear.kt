package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager

class Clear: Command {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(arg: Array<*>, collectionManager: CollectionManager) {
        writeToConsole.writelnToConsole(message.getMessage("clear"))
        return collectionManager.clear()
    }
}
package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager

class Clear: Command {
    private val collectionManager: CollectionManager = CollectionManager()
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(argument: String) {
        writeToConsole.writelnToConsole(message.getMessage("clear"))
        return collectionManager.getVector().clear()
    }
}
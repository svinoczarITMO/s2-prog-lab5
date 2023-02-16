package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager

class Clear: Command {
    private val collectionManager: CollectionManager = CollectionManager()
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(command: String) {
        writeToConsole.writelnToConsole(message.getMessage(command))
        return collectionManager.getVector().clear()
    }
}
package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager

class RemoveFirst: Command {
    private val collectionManager: CollectionManager = CollectionManager()
    private val writeToConsole = PrinterManager()
    private val message = Messages()
    override fun execute(argument: String) {
        collectionManager.getVector().removeFirst()
        writeToConsole.writelnToConsole(
            message.getMessage("first_element") +
                    message.getMessage("removed"))
    }
}
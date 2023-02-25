package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager

class RemoveByID: Command {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(args: Array<String>, collectionManager: CollectionManager) {
        val argument = args[0]
        collectionManager.getVector().removeAt(argument.toInt() - 1)
        writeToConsole.writelnToConsole(
            message.getMessage("by_id") +
            argument +
            message.getMessage("removed"))
    }
}
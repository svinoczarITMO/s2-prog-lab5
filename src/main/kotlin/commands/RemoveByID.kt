package commands

import data.Messages
import exceptions.ElementAmountException
import utils.CollectionManager
import utils.PrinterManager

class RemoveByID: Command {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(arg: Array<*>, collectionManager: CollectionManager) {
        try {
            collectionManager.getVector().removeAt(arg[0] as Int - 1)
            writeToConsole.writelnToConsole(
                message.getMessage("by_id") +
                        arg +
                        message.getMessage("removed")
            )
        } catch (e: ElementAmountException) {
            writeToConsole.writelnToConsole(message.getMessage("invalid argument"))
            execute(arg, collectionManager)
        }
    }
}
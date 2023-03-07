package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager

/**
 * Removes element of collection with inputed id.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class RemoveByID: Command <Int> {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(args: Array<Any>, collectionManager: CollectionManager) {
        var flag = false
        try {
            try {
                for (element in collectionManager.getVector()) {
                    if (element.id == args[0]) {
                        collectionManager.getVector().remove(element)
                        flag = true
                        break
                    }
                }
            } catch (e: ArrayIndexOutOfBoundsException) {
                return
            }

        if (flag) {
            writeToConsole.writelnInConsole(
                message.getMessage("by_id") +
                        args[0] +
                        message.getMessage("removed")
            )
        } else if (!flag){
            writeToConsole.writelnInConsole("Объект с указанным id не найден")
        }
        } catch (e: ArrayIndexOutOfBoundsException) {
            writeToConsole.writelnInConsole(message.getMessage("invalid argument"))
            return
        }
    }
}
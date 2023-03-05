package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager

class RemoveByID: Command <Int> {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(arg: Array<Any>, collectionManager: CollectionManager) {
        var flag = false
        try {
            try {
                for (element in collectionManager.getVector()) {
                    if (element.id == arg[0]) {
                        collectionManager.getVector().remove(element)
                        flag = true
                        break
                    }
                }
            } catch (e: ArrayIndexOutOfBoundsException) {
                return
            }

        if (flag) {
            writeToConsole.writelnToConsole(
                message.getMessage("by_id") +
                        arg[0] +
                        message.getMessage("removed")
            )
        } else if (!flag){
            writeToConsole.writelnToConsole("Объект с указанным id не найден")
        }
        } catch (e: ArrayIndexOutOfBoundsException) {
            writeToConsole.writelnToConsole(message.getMessage("invalid argument"))
            return
        }
    }
}
package commands

import utils.CollectionManager
import utils.PrinterManager

class Show: Command {
    private val writeToConsole = PrinterManager()

    override fun execute(args: Array<String>, collectionManager: CollectionManager) {
        if (collectionManager.getVector().size > 1) {
            for (i in 0 until collectionManager.getVector().size-1) {
                writeToConsole.writeToConsole("${collectionManager.getVector()[i].name}, ")
            }
            writeToConsole.writelnToConsole("${collectionManager.getVector().lastElement().name}.")
        } else if (collectionManager.getVector().size == 1) {
            writeToConsole.writelnToConsole(collectionManager.getVector().lastElement().name)
        } else {
            writeToConsole.writelnToConsole("В коллекции не содержится элементов. ")
        }
    }
}
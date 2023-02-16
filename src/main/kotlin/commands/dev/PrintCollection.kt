package commands.dev

import commands.Command
import utils.CollectionManager
import utils.PrinterManager

class
PrintCollection: Command {
    private val collectionManager: CollectionManager = CollectionManager()
    private val writeToConsole = PrinterManager()

    override fun execute (argument: String) {
            writeToConsole.writelnToConsole((collectionManager.getVector()).toString())
    }
}
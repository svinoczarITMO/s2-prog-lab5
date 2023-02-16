package commands.dev

import commands.Command
import utils.CollectionManager
import utils.PrinterManager

class Print: Command {
    private val collectionManager: CollectionManager = CollectionManager()
    private val writeToConsole = PrinterManager()

    override fun execute (command: String) {
            writeToConsole.writelnToConsole((collectionManager.getVector()).toString())
    }
}
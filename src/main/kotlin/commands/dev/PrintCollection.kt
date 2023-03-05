package commands.dev

import commands.Command
import utils.CollectionManager
import utils.PrinterManager

class
PrintCollection: Command <Any> {
    private val writeToConsole = PrinterManager()

    override fun execute(arg: Array<Any>, collectionManager: CollectionManager) {
        writeToConsole.writelnToConsole(collectionManager.getVector().toString())
    }
}
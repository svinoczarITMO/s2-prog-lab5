package commands.dev

import commands.Command
import utils.CollectionManager
import utils.PrinterManager

class
PrintCollection: Command {
    private val writeToConsole = PrinterManager()

    override fun execute(arg: Array<*>, collectionManager: CollectionManager) {
        writeToConsole.writelnToConsole(collectionManager.getVector().toString())
//    println(collectionManager.getVector())
    }
}
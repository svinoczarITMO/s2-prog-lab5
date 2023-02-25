package commands.dev

import commands.Command
import utils.CollectionManager
import utils.PrinterManager

class
PrintCollection: Command {
    private val writeToConsole = PrinterManager()

    override fun execute(args: Array<String>, collectionManager: CollectionManager) {
        writeToConsole.writelnToConsole(collectionManager.toString())
//    println(collectionManager.getVector())
    }
}
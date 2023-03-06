package commands.dev

import commands.Command
import utils.CollectionManager
import utils.PrinterManager

/**
 * Prints all elemets of collection as units.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class PrintCollection: Command <Any> {
    private val writeToConsole = PrinterManager()

    override fun execute(arg: Array<Any>, collectionManager: CollectionManager) {
        writeToConsole.writelnToConsole(collectionManager.getVector().toString())
    }
}

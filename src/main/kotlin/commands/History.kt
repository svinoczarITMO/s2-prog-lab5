package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager

/**
 * Prints last 7 commands.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class History: Command <List<*>> {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(arg: Array<Any>, collectionManager: CollectionManager) {
        val commandBuffer = arg[0] as List<*>
        writeToConsole.writelnToConsole(message.getMessage("last_commands"))
        for (command in commandBuffer) {
            writeToConsole.writelnToConsole(command)
        }
        writeToConsole.writelnToConsole("")
    }


}
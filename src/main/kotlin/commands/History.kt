package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager


class History: Command <List<*>> {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(arg: Array<Any>, collectionManager: CollectionManager) {
        val commandBuffer = arg[0] as Array<*>
        writeToConsole.writelnToConsole(message.getMessage("last_commands"))
        for (command in commandBuffer) {
            writeToConsole.writelnToConsole(command)
        }
        writeToConsole.writelnToConsole("")
    }


}
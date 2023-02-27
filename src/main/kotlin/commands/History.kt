package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager


class History: Command {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(arg: Array<*>, collectionManager: CollectionManager) {
        val commandBuffer = arg[0] as List<*>
        writeToConsole.writelnToConsole(message.getMessage("last_commands"))
        for (command in commandBuffer) {
            writeToConsole.writelnToConsole(command)
        }
        writeToConsole.writelnToConsole("")
    }


}
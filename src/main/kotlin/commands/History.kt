package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager


class History: Command {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(args: Array<String>, collectionManager: CollectionManager) {
        val commandBuffer = args
        writeToConsole.writelnToConsole(message.getMessage("last_commands"))
        for (c in commandBuffer) {
            writeToConsole.writelnToConsole(c)
        }
        writeToConsole.writelnToConsole("")
    }


}
package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager
import java.util.*


class History: Command {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(args: Array<String>, collectionManager: CollectionManager) {
        writeToConsole.writelnToConsole(message.getMessage("last_commands"))
        for (command in commandBuffer) {
            writeToConsole.writelnToConsole(command)
        }
        writeToConsole.writelnToConsole("")
    }

    private var commandBuffer: LinkedList<String> = LinkedList<String>()
    fun writeInBuffer(command: String) {
        if (commandBuffer.size == 7) {
            commandBuffer.pop()
            commandBuffer.add(command)
        } else {
            commandBuffer.add(command)
        }
    }
}
package utils

import java.util.*

class Validator {
    private val commandManager = CommandManager()
    private val commandBuffer = LinkedList<String>()

    fun validation(args: Array<String>, collectionManager: CollectionManager) {
        val command = commandManager.getCommand(args[0])
        var arguments = args.slice(1 until args.size).toTypedArray()
        if (commandBuffer.size == 7) {
            commandBuffer.pop()
            commandBuffer.add(args[0])
        } else {
            commandBuffer.add(args[0])
        }
        arguments += commandBuffer.toTypedArray()
        command?.execute(arguments, collectionManager)
    }
}
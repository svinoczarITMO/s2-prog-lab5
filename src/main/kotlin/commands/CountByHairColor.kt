package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager

class CountByHairColor: Command {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(arg: Array<*>, collectionManager: CollectionManager) {
        val copyVector = collectionManager.getVector()
        var counter = 0
        try {
            for (element in copyVector) {
                if (element.hairColor == arg[0]) {
                    counter += 1
                }
            }
            writeToConsole.writelnToConsole("Количество людей с цветом волос \"${arg.toString().capitalize()}\": $counter")
        } catch (e: IllegalArgumentException) {
            writeToConsole.writelnToConsole(message.getMessage("IllegalColor"))
        }
    }
}
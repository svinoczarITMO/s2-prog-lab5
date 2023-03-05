package commands

import data.Color
import data.Messages
import utils.CollectionManager
import utils.PrinterManager

class CountByHairColor: Command <Color> {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(arg: Array<Any>, collectionManager: CollectionManager) {
        val copyVector = collectionManager.getVector()
        var counter = 0
        try {
            for (element in copyVector) {
                if (element.hairColor == arg[0]) {
                    counter += 1
                }
            }
            writeToConsole.writelnToConsole("Количество людей с цветом волос \"${arg[0].toString().capitalize()}\": $counter")
        } catch (e: IllegalArgumentException) {
            writeToConsole.writelnToConsole(message.getMessage("IllegalColor"))
        }
    }
}
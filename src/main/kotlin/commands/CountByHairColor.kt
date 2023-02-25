package commands

import data.Color
import data.Messages
import utils.CollectionManager
import utils.PrinterManager

class CountByHairColor: Command {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(args: Array<String>, collectionManager: CollectionManager) {
        val copyVector = collectionManager.getVector()
        val argument = args[0]
        var counter = 0
        try {
            for (element in copyVector) {
                if (element.hairColor == Color.valueOf(argument.uppercase())) {
                    counter += 1
                }
            }
            writeToConsole.writelnToConsole("Количество людей с цветом волос \"${argument.capitalize()}\": $counter")
        } catch (e: IllegalArgumentException) {
            writeToConsole.writelnToConsole(message.getMessage("IllegalColor"))
        }
    }
    //linked hash map
}
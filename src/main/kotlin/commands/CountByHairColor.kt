package commands

import data.Color
import data.Messages
import utils.CollectionManager
import utils.PrinterManager

/**
 * Counts elements by hair color.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class CountByHairColor: Command <Color> {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(args: Array<Any>, collectionManager: CollectionManager) {
        val copyVector = collectionManager.getVector()
        var counter = 0
        try {
            for (element in copyVector) {
                if (element.hairColor == args[0]) {
                    counter += 1
                }
            }
            writeToConsole.writelnInConsole("Количество людей с цветом волос \"${args[0].toString().capitalize()}\": $counter")
        } catch (e: IllegalArgumentException) {
            writeToConsole.writelnInConsole(message.getMessage("IllegalColor"))
        }
    }
}
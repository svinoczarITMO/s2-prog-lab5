package commands

import data.Color
import utils.CollectionManager
import utils.PrinterManager

class CountByHairColor: Command {
    private val copyVector = CollectionManager().getVector()
    private val writeToConsole = PrinterManager()
    override fun execute(argument: String) {
        var counter: Int = 0
        for (element in copyVector) {
            if (element.hairColor == Color.valueOf(argument.uppercase())) {
                counter += 1
            }
        }
        writeToConsole.writelnToConsole("Количество людей с цветом волос \"${argument.capitalize()}\": $counter")

    }
}
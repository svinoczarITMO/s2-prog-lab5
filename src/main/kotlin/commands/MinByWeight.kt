package commands

import commands.dev.GetElement
import data.Messages
import utils.CollectionManager
import utils.PrinterManager


class MinByWeight: Command {
    private val collectionManager: CollectionManager = CollectionManager()
    private val getElement: GetElement = GetElement()
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(argument: String) {
        val minWeightElements: MutableMap<Int, Long> = mutableMapOf()
        if (collectionManager.getVector().size > 1) {
            for ((counter, element) in collectionManager.getVector().withIndex()) {
                minWeightElements[counter] = element.weight
            }
            val minWeightElement = minWeightElements.minOf {it.key}
            println(minWeightElement)
            writeToConsole.writelnToConsole(message.getMessage("min_weight"))
            getElement.execute((collectionManager.getVector().elementAt(minWeightElement)).toString())
        } else {
            writeToConsole.writelnToConsole(message.getMessage("min_weight"))
            getElement.execute("1")
        }
    }
}
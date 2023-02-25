package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager
import utils.Validator


class MinByWeight: Command {
    private val validator = Validator()
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(args: Array<String>, collectionManager: CollectionManager) {
        val vector = collectionManager.getVector()
        val minWeightElements: MutableMap<Int, Long> = mutableMapOf()
        if (vector.size > 1) {
            for ((counter, element) in vector.withIndex()) {
                minWeightElements[counter] = element.weight
            }
            val minWeightElement = minWeightElements.minOf {it.key}
            println(minWeightElement)
            writeToConsole.writelnToConsole(message.getMessage("min_weight"))
            val temp_args = arrayOf("getElement", vector.elementAt(minWeightElement).toString())
            validator.validation(temp_args, collectionManager)
        } else {
            writeToConsole.writelnToConsole(message.getMessage("min_weight"))
            val temp_args = arrayOf("getElement", "1")
            validator.validation(temp_args, collectionManager)
        }
    }
}
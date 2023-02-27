package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager
import utils.Validator


class MinByWeight: Command {
    private val validator = Validator()
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(arg: Array<*>, collectionManager: CollectionManager) {
        val tempCollectionManager = CollectionManager()
        val vector = collectionManager.getVector()
        val minWeightElements: MutableMap<Int, Long> = mutableMapOf()

        if (vector.size > 1) {
            for ((counter, element) in vector.withIndex()) {
                println(element.weight)
                minWeightElements[counter] = element.weight
            }
            val minWeight = minWeightElements.minOf {it.key}
            val minByWeightElement = vector.get(minWeight)
            val minByWeightElementId = arrayOf("get", minByWeightElement.id.toString())
            writeToConsole.writelnToConsole(message.getMessage("min_weight"))
            println(minWeightElements)
//            println(min)
            //val id = arrayOf(vector.elementAt(minWeight).toString())
            //get?.execute(id, collectionManager)
            validator.validation(minByWeightElementId, tempCollectionManager)
        } else {
            writeToConsole.writelnToConsole(message.getMessage("min_weight"))
            val temp_args = arrayOf("getElement", "1")
            validator.validation(temp_args, collectionManager)
        }
    }
}
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
        val vector = collectionManager.getVector()
        var minWeight: Long = Long.MAX_VALUE
        var minWeightId: String = "0"
        for (element in vector) {
            if (element.weight < minWeight) {
                minWeight = element.weight
                minWeightId = element.id.toString()
            }
        }
        println(minWeight)
        println(minWeightId)
        validator.validation(arrayOf("get", minWeightId), collectionManager)
    }
}
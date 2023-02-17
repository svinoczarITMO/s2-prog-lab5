package commands

import commands.dev.GetElement
import data.Messages
import utils.CollectionManager
import utils.PrinterManager


class MinByWeight: Command {
//fun minWeightElement() {
//    val copyVector = CollectionManager.vector
//    var minWeightElements: MutableMap<Int, Long> = mutableMapOf()
//    for (element in copyVector) {
//        minWeightElements.put(element.id, element.weight)
//    }
//    var minWeightElement = minWeightElements.minBy { it.value }
//    CollectionManager.getElement(minWeightElement.key - 1)
//    }
    private val collectionManager: CollectionManager = CollectionManager()
    private val getElement: GetElement = GetElement()
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(argument: String) {
//        val copyVector = collectionManager.getVector()
        val minWeightElements: MutableMap<Int, Long> = mutableMapOf()
        for (element in collectionManager.getVector()) {
            minWeightElements.put(element.id, element.weight)
        }
        val minWeightElement = minWeightElements.minBy { it.value }
//        if collectionManager.getVector().elementAt(minWeightElement.key-1).id
        writeToConsole.writelnToConsole("Объект коллекции с минимальным весом:")
        getElement.execute((collectionManager.getVector().elementAt(minWeightElement.key - 1)).id.toString())
    //(minWeightElement.key - 1)
    }
}
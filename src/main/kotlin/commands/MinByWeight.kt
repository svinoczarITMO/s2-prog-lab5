package commands

import utils.CollectionManager


class MinByWeight: Command {
fun minWeightElement() {
    val copyVector = CollectionManager.vector
    var minWeightElements: MutableMap<Int, Long> = mutableMapOf()
    for (element in copyVector) {
        minWeightElements.put(element.id, element.weight)
    }
    var minWeightElement = minWeightElements.minBy { it.value }
    CollectionManager.getElement(minWeightElement.key - 1)
    }
}
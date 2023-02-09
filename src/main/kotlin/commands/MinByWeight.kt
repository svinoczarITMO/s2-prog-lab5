package commands

import CollectionController


class MinByWeight {
    companion object {
    fun minWeightElement() {
        val copyVector = CollectionController.vector
        var minWeightElements: MutableMap<Int, Long> = mutableMapOf()
        for (element in copyVector) {
            minWeightElements.put(element.id, element.weight)
        }
        var minWeightElement = minWeightElements.minBy { it.value }
        CollectionController.getElement(minWeightElement.key - 1)
        }
    }
}
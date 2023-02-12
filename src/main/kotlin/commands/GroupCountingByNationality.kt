package commands

import utils.CollectionController
import data.Country

class GroupCountingByNationality: Command {
    fun groupByNationality () {
        val copyVector = CollectionController.vector
        var bufferVector = CollectionController.vector
        var counter: Int = 0

        for (nationality in Country.values()) {
            val mainNationality = nationality.toString()
            var counterOfElementsInGroup: Int = 0
            for (element in copyVector) {
                if (element.nationality.toString() == mainNationality) {
                    bufferVector.insertElementAt(element,counter)
                    counter += 1
                    counterOfElementsInGroup += 1
                }
            }
            println("В группе $nationality $counterOfElementsInGroup человек")
        }
    }
}
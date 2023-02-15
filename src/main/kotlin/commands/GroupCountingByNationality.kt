package commands

import data.Country
import utils.CollectionManager

class GroupCountingByNationality: Command {
    fun groupByNationality () {
        val copyVector = CollectionManager().getVector()
        var bufferVector = copyVector
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

    override fun execute(command: String) {
        TODO("Not yet implemented")
    }
}
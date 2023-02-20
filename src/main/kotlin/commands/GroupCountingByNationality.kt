package commands

import data.Country
import data.Person
import utils.CollectionManager
import utils.PrinterManager
import java.util.*

class GroupCountingByNationality: Command {
    private val collectionManager: CollectionManager = CollectionManager()
    private val writeToConsole = PrinterManager()

    override fun execute(argument: String) {
        val bufferVector = Vector<Person>()
        var counter = 0

        for (nationality in Country.values()) {
            val mainNationality = nationality.toString()
            var counterOfElementsInGroup = 0
            for (element in collectionManager.getVector()) {
                if (element.nationality.toString() == mainNationality) {
                    bufferVector.insertElementAt(element, counter)
                    counter += 1
                    counterOfElementsInGroup += 1
                }
            }
            writeToConsole.writelnToConsole("В группе $nationality $counterOfElementsInGroup человек")
        }
        collectionManager.setVector(bufferVector)
    }
}

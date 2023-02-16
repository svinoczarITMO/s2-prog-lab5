package commands

import data.Country
import data.Messages
import utils.CollectionManager
import utils.PrinterManager

class GroupCountingByNationality: Command {
    private val collectionManager: CollectionManager = CollectionManager()
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(argument: String) {
        val bufferVector = collectionManager.getVector()
        var counter: Int = 0

        for (nationality in Country.values()) {
            val mainNationality = nationality.toString()
            var counterOfElementsInGroup: Int = 0
            for (element in collectionManager.getVector()) {
                if (element.nationality.toString() == mainNationality) {
                    bufferVector.insertElementAt(element,counter)
                    counter += 1
                    counterOfElementsInGroup += 1
                }
            }
            writeToConsole.writelnToConsole("В группе $nationality $counterOfElementsInGroup человек")
        }
    }
}
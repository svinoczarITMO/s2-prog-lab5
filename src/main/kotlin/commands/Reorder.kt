package commands

import data.Messages
import data.Person
import utils.CollectionManager
import utils.PrinterManager
import java.util.*

class Reorder: Command {
    private val collectionManager: CollectionManager = CollectionManager()
    private val writeToConsole = PrinterManager()
    private val message = Messages()
    override fun execute(argument: String) {
        val bufferVector: Vector<Person> = Vector()
        for (element in collectionManager.getVector()) {
            bufferVector.insertElementAt(element,0)
        }
        collectionManager.setVector(bufferVector)
        writeToConsole.writelnToConsole("s")
    }
}
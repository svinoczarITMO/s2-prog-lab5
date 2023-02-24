package commands

import data.Coordinates
import data.Location
import data.Messages
import data.Person
import utils.AddPersonFields
import utils.CollectionManager
import utils.PrinterManager
import utils.ReaderManager
import java.util.*

class Add: Command {
    private val collectionManager: CollectionManager = CollectionManager()
    private val readerManager: ReaderManager = ReaderManager()
    private val writeToConsole = PrinterManager()
    private val message = Messages()
    private val set = AddPersonFields()

    override fun execute(argument: String) {

        val id: Int = collectionManager.getVector().size+1

        val name: String = set.name()

        val coordinates = Coordinates(set.coordinateX(),set.coordinateY())

        val creationDate = Date()

        val height = set.height()

        val weight = set.weight()

        val hairColor = set.hairColor()

        val nationality = set.nationality()

        val location = Location(set.locationX(), set.locationY(), set.locationZ())

        val personElement =
            Person(id, name, coordinates, creationDate, height, weight, hairColor, nationality, location)
        collectionManager.addObject(personElement)
    }
}
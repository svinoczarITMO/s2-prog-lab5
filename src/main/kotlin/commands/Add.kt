package commands

import data.*
import utils.CollectionManager
import utils.PrinterManager
import utils.ReaderManager
import java.util.*

class Add: Command {
    private val collectionManager: CollectionManager = CollectionManager()
    private val readerManager: ReaderManager = ReaderManager()
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(argument: String) {
        val id: Int = collectionManager.getVector().size+1

        writeToConsole.writelnToConsole(message.getMessage("enter_name"))
        val name: String = readerManager.readFromConsole()

        writeToConsole.writelnToConsole(message.getMessage("enter_coordinateX"))
        val coordinateX: Float = readerManager.readFromConsole().toFloat()

        writeToConsole.writelnToConsole(message.getMessage("enter_coordinateY"))
        val coordinateY: Float = readerManager.readFromConsole().toFloat()
        val coordinates = Coordinates(coordinateX, coordinateY)

        val creationDate = Date()

        writeToConsole.writelnToConsole(message.getMessage("enter_height"))
        val height: Int = readerManager.readFromConsole().toInt()

        writeToConsole.writelnToConsole(message.getMessage("enter_weight"))
        val weight: Long = readerManager.readFromConsole().toLong()

        writeToConsole.writelnToConsole(message.getMessage("enter_hairColor"))
        for (value in Color.values()) {
            writeToConsole.writeToConsole("$value, ")
        }
        writeToConsole.writelnToConsole("")
        val hairColor: Color = Color.valueOf(readerManager.readFromConsole().uppercase())

        writeToConsole.writelnToConsole(message.getMessage("enter_nationality"))
        for (value in Country.values()) {
            writeToConsole.writeToConsole("$value, ")
        }
        writeToConsole.writelnToConsole("")
        val nationality: Country = Country.valueOf(readerManager.readFromConsole().uppercase())

        writeToConsole.writelnToConsole(message.getMessage("enter_locationX"))
        val locationX: Int = readerManager.readFromConsole().toInt()
        writeToConsole.writelnToConsole(message.getMessage("enter_locationY"))
        val locationY: Long = readerManager.readFromConsole().toLong()
        writeToConsole.writelnToConsole(message.getMessage("enter_locationZ"))
        val locationZ: Int = readerManager.readFromConsole().toInt()
        val location = Location(locationX, locationY, locationZ)

        val personElement =
            Person(id, name, coordinates, creationDate, height, weight, hairColor, nationality, location)
        collectionManager.addObject(personElement)
    }
}
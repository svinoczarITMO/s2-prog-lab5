package commands

import data.*
import utils.CollectionManager
import utils.PrinterManager
import java.util.*

class Add: Command {
    private var collectionManager: CollectionManager = CollectionManager()
    private val writeToConsole = PrinterManager()

    override fun execute(command: String) {
        val message = Messages()

        val id: Int = collectionManager.getVector().size + 1

        writeToConsole.writelnToConsole(message.getMessage("name"))
        val name: String = readln()

        writeToConsole.writelnToConsole(message.getMessage("coordinateX"))
        val coordinateX: Float = readln().toFloat()
        writeToConsole.writelnToConsole(message.getMessage("coordinateY"))
        val coordinateY: Float = readln().toFloat()
        val coordinates: Coordinates = Coordinates(coordinateX, coordinateY)

        val creationDate: Date = Date()

        writeToConsole.writelnToConsole(message.getMessage("height"))
        val height: Int = readln().toInt()

        writeToConsole.writelnToConsole(message.getMessage("weight"))
        val weight: Long = readln().toLong()

        writeToConsole.writelnToConsole(message.getMessage("hairColor"))
        for (value in Color.values()) {
            print("$value, ")
        }
        println()
        val hairColor: Color = Color.valueOf(readln().uppercase())

        writeToConsole.writelnToConsole(message.getMessage("nationality"))
        for (value in Country.values()) {
            print("$value, ")
        }
        println()
        val nationality: Country = Country.valueOf(readln().uppercase())

        writeToConsole.writelnToConsole(message.getMessage("locationX"))
        val locationX: Int = readln().toInt()
        writeToConsole.writelnToConsole(message.getMessage("locationY"))
        val locationY: Long = readln().toLong()
        writeToConsole.writelnToConsole(message.getMessage("locationZ"))
        val locationZ: Int = readln().toInt()
        val location: Location = Location(locationX, locationY, locationZ)

        val personElement: Person =
            Person(id, name, coordinates, creationDate, height, weight, hairColor, nationality, location)

        collectionManager.getVector().add(personElement)
    }
}
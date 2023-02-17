package commands

import data.Color
import data.Country
import data.Messages
import utils.CollectionManager
import utils.PrinterManager


class Update: Command {
    private val collectionManager: CollectionManager = CollectionManager()
    private val writeToConsole = PrinterManager()
    private val message = Messages()
    override fun execute(argument: String) {
        val element = collectionManager.getVector().elementAt(argument.toInt() - 1)

        writeToConsole.writelnToConsole(message.getMessage("enter_name"))
        element.name = readln()

        writeToConsole.writelnToConsole(message.getMessage("enter_coordinateX"))
        element.coordinates.x = readln().toFloat()
        writeToConsole.writelnToConsole(message.getMessage("enter_coordinateY"))
        element.coordinates.y = readln().toFloat()

        writeToConsole.writelnToConsole(message.getMessage("enter_height"))
        element.height = readln().toInt()

        writeToConsole.writelnToConsole(message.getMessage("enter_weight"))
        element.weight = readln().toLong()

        writeToConsole.writelnToConsole(message.getMessage("enter_hairColor"))
        for (value in Color.values()) {
            writeToConsole.writeToConsole(value.toString() + ", ")
        }
        writeToConsole.writelnToConsole("")
        element.hairColor = Color.valueOf(readln().uppercase())

        writeToConsole.writelnToConsole(message.getMessage("enter_nationality"))
        for (value in Country.values()) {
            writeToConsole.writeToConsole(value.toString() + ", ")
        }
        writeToConsole.writelnToConsole("")
        element.nationality = Country.valueOf(readln().uppercase())

        writeToConsole.writelnToConsole(message.getMessage("enter_locationX"))
        element.location.x = readln().toInt()
        writeToConsole.writelnToConsole(message.getMessage("enter_locationY"))
        element.location.y = readln().toLong()
        writeToConsole.writelnToConsole(message.getMessage("enter_locationZ"))
        element.location.z = readln().toInt()
    }
}
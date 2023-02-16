package commands.dev

import commands.Command
import data.*
import utils.CollectionManager
import utils.PrinterManager
import java.util.*

class Fadd: Command {
    private val collectionManager: CollectionManager = CollectionManager()
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(command: String) {
        val id: Int = collectionManager.getVector().size + 1001
        val obj: Person = Person(id, "Jesus", Coordinates(0f,0f), Date(), 305, 0, Color.RED, Country.USA, Location(0,0,0))
        writeToConsole.writelnToConsole("Объект успешно добавлен.")
        collectionManager.getVector().add(obj)
    }
}
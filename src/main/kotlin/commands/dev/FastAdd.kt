package commands.dev

import commands.Command
import data.*
import utils.CollectionManager
import utils.PrinterManager
import java.util.*

class FastAdd: Command {
    private val writeToConsole = PrinterManager()

    override fun execute(args: Array<String>, collectionManager: CollectionManager) {
        val id: Int = collectionManager.getVector().size + 1001
        val obj = Person(id, "Jesus", Coordinates(0f,0f), Date(), 305, 0, Color.RED, Country.USA, Location(0,0,0))
        writeToConsole.writelnToConsole("Объект успешно добавлен.")
        collectionManager.addObject(obj)
    }
}
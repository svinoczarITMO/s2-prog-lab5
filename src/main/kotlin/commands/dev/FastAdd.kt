package commands.dev

import commands.Command
import data.*
import utils.CollectionManager
import utils.PrinterManager

class FastAdd: Command {
    private val writeToConsole = PrinterManager()

    override fun execute(arg: Array<*>, collectionManager: CollectionManager) {
        val id: Int = collectionManager.getVector().size + 1001
        val obj = Person(id, "Jesus", Coordinates(0f,0f), collectionManager.parseDate("Fri Jul 19 12:00:00 MSK 2023"), 305, 0, Color.RED, Country.USA, Location(0,0,0))
        writeToConsole.writelnToConsole("Объект успешно добавлен.")
        collectionManager.addObject(obj)
    }
}
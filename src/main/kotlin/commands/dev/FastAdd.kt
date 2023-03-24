package commands.dev

import commands.Command
import data.*

/**
 * Adds new element to collection without input arguments.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class FastAdd: Command() {
    override fun execute(args: Map<String, Any>) {
        val id: Int = collectionManager.getVector().size + 1001
        val obj = Person(id, "Jesus", Coordinates(0f,0f), collectionManager.parseDate("Fri Jul 19 12:00:00 MSK 2023"), 305, 0, Color.RED, Country.USA, Location(0,0,0))
        write.linesInConsole("Объект успешно добавлен.")
        collectionManager.addObject(obj)
    }
}
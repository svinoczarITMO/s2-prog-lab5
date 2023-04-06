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
    override fun getName(): String {
        return "fadd"
    }

    override fun getDescription(): String {
        return getName() + " - добавляет новый элемент в коллекцию без указания параметров элемента\n"
    }

    override fun execute(args: Map<String, Any?>): String? {
        val id: Int = if (collectionManager.collection.isNotEmpty()) collectionManager.collection.maxOf { it.id } + 1000 else 1000
        val obj = Person(id, "Jesus", Coordinates(0f,0f), collectionManager.parseDate("Fri Jul 19 12:00:00 MSK 2023"), 305, 0, Color.RED, Country.USA, Location(0,0,0))
        collectionManager.collection.add(obj)
        val result = message.getMessage("added")
        return result
    }
}
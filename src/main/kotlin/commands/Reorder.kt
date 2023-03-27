package commands

import data.Person
import java.util.*

/**
 * Turns the collection.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Reorder: Command() {
    override fun getName(): String {
        return "reorder"
    }

    override fun getDescription(): String {
        return getName() + " - сортирует коллекцию в порядке, обратном нынешнему\n"
    }
    override fun execute(args: Map<String, Any?>) {
        val bufferVector: Vector<Person> = Vector()
        for (element in collectionManager.getVector()) {
            bufferVector.insertElementAt(element,0)
        }
        collectionManager.setVector(bufferVector)
        write.linesInConsole(collectionManager.getVector().toString())
    }
}
package commands

import data.Country
import data.Person
import java.util.*

/**
 * Counts and groups elements by nationality.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class GroupCountingByNationality: Command() {
    override fun execute(args: Map<String, Any?>) {
        val bufferVector = Vector<Person>()
        var counter = 0

        for (nationality in Country.values()) {
            val mainNationality = nationality.toString()
            var counterOfElementsInGroup = 0
            for (element in collectionManager.getVector()) {
                if (element.nationality.toString() == mainNationality) {
                    bufferVector.insertElementAt(element, counter)
                    counter += 1
                    counterOfElementsInGroup += 1
                }
            }
            write.linesInConsole("В группе $nationality $counterOfElementsInGroup человек")
        }
        collectionManager.setVector(bufferVector)
    }
}

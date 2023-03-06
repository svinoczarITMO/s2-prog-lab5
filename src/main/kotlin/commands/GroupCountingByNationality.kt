package commands

import data.Country
import data.Person
import utils.CollectionManager
import utils.PrinterManager
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty

/**
 * Counts and groups elements by nationality.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class GroupCountingByNationality: Command <Empty> {
    private val writeToConsole = PrinterManager()

    override fun execute(arg: Array<Any>, collectionManager: CollectionManager) {
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
            writeToConsole.writelnToConsole("В группе $nationality $counterOfElementsInGroup человек")
        }
        collectionManager.setVector(bufferVector)
    }
}

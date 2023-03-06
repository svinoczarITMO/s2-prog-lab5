package commands

import utils.CollectionManager
import utils.PrinterManager
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty

//TODO: Изменить описание класса.
/**
 * Prints all elements of collection.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Show: Command <Empty> {
    private val writeToConsole = PrinterManager()

    override fun execute(arg: Array<Any>, collectionManager: CollectionManager) {
        if (collectionManager.getVector().size > 1) {
            for (i in 0 until collectionManager.getVector().size-1) {
                writeToConsole.writeToConsole("${collectionManager.getVector()[i].name}, ")
            }
            writeToConsole.writelnToConsole("${collectionManager.getVector().lastElement().name}.")
        } else if (collectionManager.getVector().size == 1) {
            writeToConsole.writelnToConsole(collectionManager.getVector().lastElement().name)
        } else {
            writeToConsole.writelnToConsole("В коллекции не содержится элементов. ")
        }
    }
}
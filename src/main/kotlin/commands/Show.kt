package commands

import data.Messages
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
    private val messages = Messages()

    override fun execute(args: Array<Any>, collectionManager: CollectionManager) {
        if (collectionManager.getVector().size > 1) {
            for (i in 0 until collectionManager.getVector().size-1) {
                writeToConsole.writeInConsole("${collectionManager.getVector()[i].name}, ")
            }
            writeToConsole.writelnInConsole("${collectionManager.getVector().lastElement().name}.")
        } else if (collectionManager.getVector().size == 1) {
            writeToConsole.writelnInConsole(collectionManager.getVector().lastElement().name)
        } else {
            writeToConsole.writelnInConsole(messages.getMessage("clean_collection"))
        }
    }
}
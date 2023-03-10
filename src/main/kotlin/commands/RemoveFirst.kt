package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty

/**
 * Removes the first element of collection.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class RemoveFirst: Command <Empty> {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(args: Array<Any>, collectionManager: CollectionManager) {
        collectionManager.getVector().removeFirst()
        writeToConsole.writelnInConsole(
            message.getMessage("first_element") +
                    message.getMessage("removed"))
    }
}
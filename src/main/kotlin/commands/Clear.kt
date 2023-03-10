package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty

/**
 * Clears collection.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Clear: Command <Empty> {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(args: Array<Any>, collectionManager: CollectionManager) {
        writeToConsole.writelnInConsole(message.getMessage("clear"))
        return collectionManager.clear()
    }
}
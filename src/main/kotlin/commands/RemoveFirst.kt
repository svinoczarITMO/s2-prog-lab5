package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty

class RemoveFirst: Command <Empty> {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(arg: Array<Any>, collectionManager: CollectionManager) {
        collectionManager.getVector().removeFirst()
        writeToConsole.writelnToConsole(
            message.getMessage("first_element") +
                    message.getMessage("removed"))
    }
}
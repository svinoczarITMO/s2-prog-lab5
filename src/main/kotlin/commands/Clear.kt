package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty

class Clear: Command <Empty> {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(arg: Array<Any>, collectionManager: CollectionManager) {
        writeToConsole.writelnToConsole(message.getMessage("clear"))
        return collectionManager.clear()
    }
}
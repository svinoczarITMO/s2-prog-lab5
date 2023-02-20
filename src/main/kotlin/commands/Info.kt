package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager
import kotlin.reflect.full.valueParameters


class Info: Command {
    private val collectionManager: CollectionManager = CollectionManager()
    private val reflexion = collectionManager::getVector
    private var type = reflexion.returnType
    private var date = 2
    private var size = reflexion.valueParameters.size
    private val writeToConsole = PrinterManager()
    private val message = Messages()
    override fun execute(argument: String) {
        writeToConsole.writelnToConsole(
            type.toString().split(".")[2] + ", "
                    + "Размер: " + collectionManager.getVector().size + ", "
                    + "Дата инициализации: " + collectionManager.getVector())
    }

}

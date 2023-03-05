package commands

import utils.CollectionManager
import utils.Logger
import utils.PrinterManager
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty


class Info: Command <Empty> {
    private val writeToConsole = PrinterManager()
    private val logger = Logger()

    override fun execute(arg: Array<Any>, collectionManager: CollectionManager) {
        val typeArray = collectionManager::getVector.returnType.toString().split(".")
        val type = typeArray[2] + "." + typeArray[3]
        val size = collectionManager.getVector().size
        val initDate = logger.initDate(collectionManager)
        writeToConsole.writelnToConsole(
                    "Тип: " + type + "\n"
                    + "Размер: " + size + "\n"
                    + "Дата инициализации: " + initDate)
    }

}

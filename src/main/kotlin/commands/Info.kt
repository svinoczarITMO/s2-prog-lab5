package commands

import utils.Logger

/**
 * Prints collection information.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Info: Command() {
    private val logger = Logger()
    override fun execute(args: Map<String, Any>) {
        val typeArray = collectionManager::getVector.returnType.toString().split(".")
        val type = typeArray[2] + "." + typeArray[3]
        val size = collectionManager.getVector().size
        val initDate = logger.initDate(collectionManager)
        write.linesInConsole(
                    "Тип: " + type + "\n"
                    + "Размер: " + size + "\n"
                    + "Дата инициализации: " + initDate)
    }
}

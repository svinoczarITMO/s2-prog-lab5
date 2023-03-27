package commands

/**
 * Removes the first element of collection.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class RemoveFirst: Command() {
    override fun getName(): String {
        return "remove_first"
    }

    override fun getDescription(): String {
        return getName() + " - удаляет первый элемент из коллекции\n"
    }
    override fun execute(args: Map<String, Any?>) {
        collectionManager.getVector().removeFirst()
        write.linesInConsole(
            message.getMessage("first_element") +
                    message.getMessage("removed"))
    }
}
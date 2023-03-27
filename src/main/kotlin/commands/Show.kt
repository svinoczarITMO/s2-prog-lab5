package commands

/**
 * Prints pairs "id - name" of elements in the collection.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Show: Command() {
    override fun getName(): String {
        return "show"
    }

    override fun getDescription(): String {
        return getName() + " - выводит в стандартный поток вывода все элементы коллекции в строковом представлении\n"
    }

    override fun execute(args: Map<String, Any?>) {
        if (collectionManager.getVector().size > 1) {
            for (i in 0 until collectionManager.getVector().size-1) {
                write.inConsole("Id: ${collectionManager.getVector()[i].id}, Name: ${collectionManager.getVector()[i].name}\n")
            }
            write.linesInConsole("Id: ${collectionManager.getVector().lastElement().id}, Name: ${collectionManager.getVector().lastElement().name}")
        } else if (collectionManager.getVector().size == 1) {
            write.linesInConsole("Id: ${collectionManager.getVector().lastElement().id}, Name: ${collectionManager.getVector().lastElement().name}")
        } else {
            write.linesInConsole(message.getMessage("clean_collection"))
        }
    }
}
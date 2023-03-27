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
        if (collectionManager.collection.size > 1) {
            for (i in 0 until collectionManager.collection.size-1) {
                write.inConsole("Id: ${collectionManager.collection.elementAt(i)}, Name: ${collectionManager.collection.elementAt(i).name}\n")
            }
            write.linesInConsole("Id: ${collectionManager.collection.elementAt(collectionManager.collection.size-1).id}, " +
                    "Name: ${collectionManager.collection.elementAt(collectionManager.collection.size-1).name}")
        } else if (collectionManager.collection.size == 1) {
            write.linesInConsole("Id: ${collectionManager.collection.elementAt(collectionManager.collection.size-1).id}, " +
                    "Name: ${collectionManager.collection.elementAt(collectionManager.collection.size-1).name}")
        } else {
            write.linesInConsole(message.getMessage("clean_collection"))
        }
    }
}
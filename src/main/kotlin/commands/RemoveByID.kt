package commands

/**
 * Removes element of collection with inputed id.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class RemoveByID: Command() {
    override fun getName(): String {
        return "remove_by_id"
    }

    override fun getDescription(): String {
        return getName() + " --id - удаляет элемент из коллекции по его id\n"
    }

    override fun execute(args: Map<String, Any?>) {
        var flag = false
        val id: Int by args
        try {
            try {
                for (element in collectionManager.collection) {
                    if (element.id == id) {
                        collectionManager.collection.remove(element)
                        flag = true
                        break
                    }
                }
            } catch (e: ArrayIndexOutOfBoundsException) {
                return
            }

        if (flag) {
            write.linesInConsole(
                message.getMessage("by_id") +
                        id +
                        message.getMessage("removed")
            )
        } else if (!flag){
            write.linesInConsole(message.getMessage("invalid_id"))
        }
        } catch (e: ArrayIndexOutOfBoundsException) {
            write.linesInConsole(message.getMessage("InvalidArgument"))
            return
        }
    }
}
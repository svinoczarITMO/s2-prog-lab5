package commands

/**
 * Removes element of collection with inputed id.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class RemoveByID: Command() {
    override fun execute(args: Map<String, Any>) {
        var flag = false
        val removeId = args.get("id")
        try {
            try {
                for (element in collectionManager.getVector()) {
                    if (element.id == removeId) {
                        collectionManager.getVector().remove(element)
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
                        removeId +
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
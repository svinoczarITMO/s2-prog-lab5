package commands

/**
 * Clears collection.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Clear: Command() {
    override fun execute(args: Map<String, Any>) {
        write.linesInConsole(message.getMessage("clear"))
        return collectionManager.clear()
    }
}
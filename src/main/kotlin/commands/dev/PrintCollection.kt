package commands.dev

import commands.Command

/**
 * Prints all elemets of collection as units.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class PrintCollection: Command() {
    override fun execute(args: Map<String, Any?>) {
        write.linesInConsole(collectionManager.getVector().toString())
    }
}

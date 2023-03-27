package commands.dev

import commands.Command

/**
 * Prints all elemets of collection as units.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class PrintCollection: Command() {
    override fun getName(): String {
        return "print"
    }

    override fun getDescription(): String {
        return getName() + " - выводит в терминал все объекты коллекции в развернутом виде"
    }
    override fun execute(args: Map<String, Any?>) {
        write.linesInConsole(collectionManager.collection.toString())
    }
}

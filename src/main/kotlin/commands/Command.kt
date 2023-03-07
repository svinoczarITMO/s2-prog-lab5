package commands

import utils.CollectionManager

/**
 * Base interface for command implementation. You should implement it before applying command in CommandManager.
 *
 * @author svinoczar
 * @since 1.0.0
 */
interface Command <T>{
    /**
     * Executes command with "arg" as arguments and "collectionManager" as Collection Manager.
     *
     * @param args array of command's arguments.
     * @param collectionManager instance of Collection Manager.
     */
    fun execute (args: Array<Any>, collectionManager: CollectionManager)
}
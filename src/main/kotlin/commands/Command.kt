package commands

import utils.CollectionManager

/**
 * Base interface for command implementation. You should implement it before applying command in CommandManager
 *
 * @author svinoczar
 * @since 1.0.0
 */
interface Command <T>{
    fun execute (arg: Array<Any>, collectionManager: CollectionManager)
}
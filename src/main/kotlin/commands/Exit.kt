package commands

import utils.CollectionManager
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty
import kotlin.system.exitProcess

/**
 * Terminates the programm.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Exit: Command <Empty> {
    override fun execute(args: Array<Any>, collectionManager: CollectionManager) {
        exitProcess(1)
    }
}
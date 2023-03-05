package commands

import utils.CollectionManager
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty
import kotlin.system.exitProcess

class Exit: Command <Empty> {
    override fun execute(arg: Array<Any>, collectionManager: CollectionManager) {
        exitProcess(1)
    }
}
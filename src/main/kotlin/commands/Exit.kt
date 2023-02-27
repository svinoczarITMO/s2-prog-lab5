package commands

import utils.CollectionManager
import kotlin.system.exitProcess

class Exit: Command {
    override fun execute(arg: Array<*>, collectionManager: CollectionManager) {
        exitProcess(1)
    }
}
package commands

import utils.CollectionManager
import kotlin.system.exitProcess

class Exit: Command {
    override fun execute(args: Array<String>, collectionManager: CollectionManager) {
        exitProcess(1)
    }
}
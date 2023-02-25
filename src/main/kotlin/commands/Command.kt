package commands

import utils.CollectionManager

interface Command {
    fun execute (args: Array<String>, collectionManager: CollectionManager)
}
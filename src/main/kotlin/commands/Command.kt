package commands

import utils.CollectionManager

interface Command {
    fun execute (arg: Array<*>, collectionManager: CollectionManager)
}
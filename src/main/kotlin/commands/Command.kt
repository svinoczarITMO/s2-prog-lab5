package commands

import utils.CollectionManager

interface Command <T>{
    fun execute (arg: Array<Any>, collectionManager: CollectionManager)
}
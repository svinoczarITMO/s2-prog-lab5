package commands

import CollectionController

class Show {
    companion object {
        fun printAllElementsAsString() {
            for (i in CollectionController.vector) {
                print("$i, ")
            }
        }
    }
}
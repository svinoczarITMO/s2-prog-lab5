package commands

import CollectionController

class Show {
    companion object {
        fun printAllElementsAsString() { //TODO: а может нужно выодить все поля???
            val vector = CollectionController.vector
            if (vector.size > 1) {
                for (i in 0..CollectionController.vector.size - 1) {
                    print("${vector[i].name}, ")
                }
            } else if (vector.size == 1) {
                print(vector.lastElement().name)
            } else {
                println("В коллекции не содержится элементов. ")
            }
        }
    }
}
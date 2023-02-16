package commands

import utils.CollectionManager

class Show: Command {
    fun printAllElementsAsString() { //TODO: а может нужно выодить все поля???
        val vector = CollectionManager().getVector()
        if (vector.size > 1) {
            for (i in 0..vector.size - 1) {
                print("${vector[i].name}, ")
            }
        } else if (vector.size == 1) {
            print(vector.lastElement().name)
        } else {
            println("В коллекции не содержится элементов. ")
        }
    }

    override fun execute(argument: String) {
        TODO("Not yet implemented")
    }
}
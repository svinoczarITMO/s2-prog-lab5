package utils

import data.Person
import java.util.*

//koin
class CollectionManager {
    private var vector = Vector<Person>()

    fun getVector (): Vector<Person> {
        return vector
    }

    fun getElement (id: Int) { //TODO сделать через рефлексию (?)

    }




    fun removeById (id: Int) {
        vector.removeAt(id-1)
    }

    fun removeFirst () {
        vector.removeFirst()
    }

    fun reorder () {
        var bufferVector: Vector<Person> = Vector()
        for (element in vector) {
            bufferVector.insertElementAt(element,0)
        }
        vector = bufferVector
    }
}
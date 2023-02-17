package utils

import data.Person
import java.util.*

//koin
class CollectionManager {
    companion object {
        var vector = Vector<Person>()
    }
    fun getVector (): Vector<Person> {
        return vector
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
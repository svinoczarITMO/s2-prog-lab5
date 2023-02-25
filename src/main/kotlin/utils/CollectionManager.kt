package utils

import data.Person
import java.util.*

//koin
class CollectionManager {
    private var vector = Vector<Person>()

    fun getVector (): Vector<Person> {
        return vector
    }

    fun setVector (newVector: Vector<Person>) {
        vector = newVector
    }

    fun addObject (obj: Person) {
        vector.addElement(obj)
    }

    fun clear () {
        vector.clear()
    }

}
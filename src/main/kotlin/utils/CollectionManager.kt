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

    fun setVector (new_vector: Vector<Person>) {
        vector = new_vector
    }

}
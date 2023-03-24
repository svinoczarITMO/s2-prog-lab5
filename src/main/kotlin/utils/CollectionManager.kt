package utils

import data.Person
import java.text.SimpleDateFormat
import java.util.*

/**
 * Manages the collection.
 *
 * @author svinoczar
 * @since 1.0.0
 */

class CollectionManager {
    private var vector = Vector<Person>()
    /**
     * Returs the collection (Vector).
     *
     * @return vector as Vector<Person>.
     */
    fun getVector (): Vector<Person> {
        return vector
    }

    /**
     * Sets a new vector.
     *
     * @param newVector Vector<Person> that will set up.
     */
    fun setVector (newVector: Vector<Person>) {
        vector = newVector
    }

    /**
     * Adds Person object to collection (Vector).
     *
     * @param obj Person object.
     */
    fun addObject (obj: Person) {
        vector.addElement(obj)
    }

    /**
     * Clears the collection (Vector).
     */
    fun clear () {
        vector.clear()
    }

    /**
     * Pairs date from string format to date format.
     *
     * @param dateString date in String format.
     */
    fun parseDate(dateString: String): Date {
        val dateFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH)
        return dateFormat.parse(dateString)
    }
}
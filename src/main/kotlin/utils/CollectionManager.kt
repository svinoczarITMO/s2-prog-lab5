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

class CollectionManager{
    var collection: MutableCollection<Person> = Vector<Person>()
    private var supportedCollectionTypes: HashMap<String, MutableCollection<Person>> = hashMapOf()

    init {
        addSupportedCollectionType("vector", Vector())
        addSupportedCollectionType("linkedlist", LinkedList())
    }

    fun changeType(newType: String) {
        if (collection == getSupportedCollectionTypes()[newType]!!) return
        val old = collection
        collection = supportedCollectionTypes[newType.lowercase()]!!
        for (element in old) {
            collection.add(element)
        }
    }

    private fun addSupportedCollectionType(name: String, collection: MutableCollection<Person>) {
        supportedCollectionTypes[name] = collection
    }

    private fun getSupportedCollectionTypes() = supportedCollectionTypes

    fun collectionToList(): List<Person> {
        return collection.toList()
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
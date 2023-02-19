package utils.serialize

import data.Person


interface Serializer {
    fun serialize(collection: LinkedHashMap<Int, Person>): String;
    fun deserialize(json: String): LinkedHashMap<Int, Person>
}
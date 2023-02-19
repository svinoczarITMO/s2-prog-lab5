package utils.serialize

import data.Person
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual


class SerializeManager: Serializer {
    private val module = SerializersModule {
        contextual(KDateSerializer)
    }

    private val serializer = Json { serializersModule = module }

    override fun serialize(collection: LinkedHashMap<Int, Person>) =
        serializer.encodeToString(collection)

    override fun deserialize(json: String) =
        serializer.decodeFromString<LinkedHashMap<Int, Person>>(json)
}
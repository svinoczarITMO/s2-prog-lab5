package utils

import data.Person
import kotlinx.serialization.KSerializer
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encodeToString
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import java.text.SimpleDateFormat
import java.util.*


class Serializer {
    fun serialize(whatToSerialize: List<Person>): String {
        return Json.encodeToString(whatToSerialize)
    }

    fun deserialize(whatToDeserialize: String): List<Person> {
        return Json.decodeFromString<List<Person>>(whatToDeserialize)
    }
}

object DateAsStringSerializer : KSerializer<Date> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Date", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: Date) {
        encoder.encodeString(value.toString())
    }
    val dateFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH)
    override fun deserialize(decoder: Decoder): Date = dateFormat.parse(decoder.decodeString())
}
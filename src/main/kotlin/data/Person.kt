package data

import java.util.*


class Person(
    var id: Int,
    var name: String,
    var coordinates: Coordinates,
    var creationDate: Date,
    var height: Int,
    var weight: Long,
    var hairColor: Color,
    var nationality: Country,
    var location: Location
) {}
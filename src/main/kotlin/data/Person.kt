package data

import java.util.Date

class Person(var id: Int,
             var name: String,
             var coordinates: Coordinates,
             var creationDate: Date, //TODO: а надо при каждом апдейте/перезаписи менять дату?
             var height: Int,
             var weight: Long,
             var hairColor: Color,
             var nationality: Country,
             var location: Location
) {

}
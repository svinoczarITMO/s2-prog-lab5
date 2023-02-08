import java.util.Date

class Person(var id: Int,
             var name: String,
             var coordinates: Coordinates,
             var creationDate: String, //TODO: поменять String на Date (придумать как подгружать дату создания из .xml)
             var height: Int,
             var weight: Long,
             var hairColor: Color,
             var nationality: Country,
             var location: Location ) {

}
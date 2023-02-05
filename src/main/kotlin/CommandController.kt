import java.util.Date
import kotlin.system.exitProcess

class CommandController {
    companion object {
        fun help () {}
        fun info () {}
        fun show () {}
        fun add () {
            var id: Int = 1

            print("Введите имя: ");
            var name: String = readln()

            print("Введите координату x: ");
            var coordinateX: Float = readln().toFloat()
            print("Введите координату y: ");
            var coordinateY: Float = readln().toFloat()
            var coordinates: Coordinates = Coordinates(coordinateX, coordinateY)

            var creationDate: Date = Date()

            print("Введите рост: ");
            var height: Int = readln().toInt()

            print("Введите вес: ");
            var weight: Long = readln().toLong()

            print("Выберите цвет волос из предложенных: ")
            for (value in Color.values()) {
                print(value.toString() + ", " )
            }
            println()
            var hairColor: Color = Color.valueOf(readln())

            print("Выберите страну рождения из предложенных: ")
            for (value in Country.values()) {
                print(value.toString() + ", " )
            }
            println()
            var nationality: Country = Country.valueOf(readln())

            print("Введите координату x: ");
            var locationX: Int = readln().toInt()
            print("Введите координату y: ");
            var locationY: Long = readln().toLong()
            print("Введите координату z: ");
            var locationZ: Int = readln().toInt()
            var location: Location = Location(locationX, locationY, locationZ)

            var musicElement: Person = Person(id, name, coordinates, creationDate, height, weight, hairColor, nationality, location)

            id++
        }
        fun update (id: Int) {
            print("Введите значение элемента: ")
            var element = readln()
        }
        fun removeById (id: Int) {}
        fun clear () {}
        fun save () {}
        fun executeScript(fileName: String) {}
        fun exit () {
            exitProcess(0)
        }
        fun removeFirst () {}
        fun recorder () {}
        fun history () {}
        fun minByWeight () {}
        fun groupCountingByNationality () {}
        fun countByHairColor () {}

    }
//    id: Int,
//    name: String,
//    coordinates: Coordinates,
//    creationDate: ZonedDateTime,
//    numberOfParticipants: Int,
//    albumsCount: Int,
//    description: String,
//    genre: MusicGenre,
//    bestAlbum: Album
}
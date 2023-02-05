import java.time.ZonedDateTime
import kotlin.random.Random
import kotlin.system.exitProcess

class CommandController {
    companion object {
        fun addEl () {
            var id: Int = 1

            print("Введите имя: ");
            var name: String = readln()
            print("Введите координату x: ");
            var coordinateX: Float = readln().toFloat()
            print("Введите координату y: ");
            var coordinateY: Double = readln().toDouble()
            var coordinates: Coordinates = Coordinates(coordinateX, coordinateY)

            var creationDate: java.time.ZonedDateTime = ZonedDateTime.now()

            print("Введите numberOfParticipants: ");
            var numberOfParticipants: Int = readln().toInt()
            print("Введите albumsCount: ");
            var albumsCount: Long = readln().toLong()
            print("Введите description: ");
            var description: String = readln()
            print("Введите genre: ");
            var genre: String = readln()
            print("Введите bestAlbum: ");
            var bestAlbum: String = readln()

            var musicElement: MusicBand = MusicBand(id, name, coordinates, creationDate, numberOfParticipants, )

            id++
        }
        fun help () {}
        fun info () {}
        fun show () {}
        fun insert (key: String) {
            print("Введите значение элемента: ")
            var element = readln()
        }
        fun update (id: Int) {
            print("Введите значение элемента: ")
            var element = readln()
        }
        fun removeKey(key: String) {}
        fun clear () {}
        fun save () {}
        fun executeScript(fileName: String) {}
        fun exit () {
            exitProcess(0)
        }
        fun removeGreater (element: String) {}
        fun replaceIfLower (key: String) {}
        fun removeGreaterKey (key: String) {}
        fun countGreaterThanDescription (description: String) {}
        fun filterLessThanGenre (name: String) {
            var genre = MusicGenre.valueOf(name)
        }
        fun printFieldDescendingNumberOfParticipants () {}

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
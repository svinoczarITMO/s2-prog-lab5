import java.time.ZonedDateTime
import kotlin.random.Random
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
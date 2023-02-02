import java.time.ZonedDateTime

class MusicBand {
    private var id: Int = TODO("id>0, уникально, ген автомат")
    private var name: String = TODO("не null, не пустая")
    private var coordinates: Coordinates = TODO("не null")
    private var creationDate: ZonedDateTime = TODO("не null, ген автомат")
    private var numberOfParticipants: Int = TODO("f>0")
    private var albumsCount: Int? = TODO("can be null, f>0")
    private var description: String = TODO()
    private var genre: MusicGenre = TODO()
    private var bestAlbum: Album = TODO()


}
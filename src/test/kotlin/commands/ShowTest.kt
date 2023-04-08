package commands

import data.*
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import utils.CollectionManager
import utils.CommandManager
import java.util.*

class ShowTest {
    private val collectionManager = CollectionManager()
    private val commandManager = CommandManager()

    @Test
    fun `Get info about collection elements`() {
        val mockkObject = mockk<Show>()
        val show = Show()
        val collection: MutableCollection<Person> = Vector<Person>()
        val person1 = Person(2,"Pavel", Coordinates(45.24f, 24.45f), Date(), 180, 77, Color.BROWN, Country.USA, Location(10, 70,30))
        val person2 = Person(3, "Nikolai", Coordinates(09f, 11f), Date(), 170, 77, Color.BROWN, Country.USA, Location(10, 70, 300))

        val string = "Id: 2, Name: Pavel\n" +
                     "Id: 3, Name: Nikolai"

        collection.add(person1)
        collection.add(person2)

        val expectedOutput = "Id: 2, Name: Pavel\n" +
                             "Id: 3, Name: Nikolai"
        val actualOutput = show.execute(mapOf("buffer" to "show", "none" to null))

        assertEquals(expectedOutput, actualOutput)
//        val expected = "В коллекции не содержится элементов."
    }
}

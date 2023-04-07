package commands

import data.*
import di.notKoinModule
import org.junit.jupiter.api.Test
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext.startKoin
import utils.CollectionManager
import utils.CommandManager
import java.util.*
import kotlin.test.assertEquals

class ShowTest: KoinComponent {
    private val collectionManager = CollectionManager()
    private val commandManager = CommandManager()

    @Test
    fun `Get info about collection elements`() {
        startKoin {
            modules(notKoinModule)
        }
        val collectionManager = CollectionManager()
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

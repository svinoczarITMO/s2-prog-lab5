package commands

import data.Coordinates
import data.Location
import data.Messages
import data.Person
import utils.AddPersonFields
import utils.CollectionManager
import utils.PrinterManager
import java.util.*


class Update: Command <Int> {
    private val set = AddPersonFields()
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(arg: Array<Any>, collectionManager: CollectionManager) {
        var id = 0
        var element: Person? = null
        try {
            for (obj in collectionManager.getVector()) {
                if (obj.id == arg[0]) {
                    element = obj
                    break
                }
            }
        } catch (e: ArrayIndexOutOfBoundsException) {
//            writeToConsole.writelnToConsole("Объект с указанным id не найден")
            return
        }

        try {
            id = element?.id as Int
        } catch (e: NullPointerException) {
            writeToConsole.writelnToConsole("Элемента с указанным id не существует")
            return
        }

        val name: String = set.name()

        val coordinates = Coordinates(set.coordinateX(),set.coordinateY())

        val creationDate = Date()

        val height = set.height()

        val weight = set.weight()

        val hairColor = set.hairColor()

        val nationality = set.nationality()

        val location = Location(set.locationX(), set.locationY(), set.locationZ())
        element = Person(id, name, coordinates, creationDate, height, weight, hairColor, nationality, location)
        collectionManager.getVector().removeAt(id-1)
        collectionManager.getVector().insertElementAt(element, id-1)
    }
}
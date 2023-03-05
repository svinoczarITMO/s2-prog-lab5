package commands

import data.Coordinates
import data.Location
import data.Person
import utils.AddPersonFields
import utils.CollectionManager
import java.util.*


class Update: Command <Int> {
    private val set = AddPersonFields()

    override fun execute(arg: Array<Any>, collectionManager: CollectionManager) {
        var element: Person? = null
        try {
            for (obj in collectionManager.getVector()) {
                if (obj.id == arg[0]) {
                    element = obj
                    break
                }
            }
        } catch (e: ArrayIndexOutOfBoundsException) {
            //writeToConsole.writelnToConsole("Объект с указанным id не найден")
        }


        val id = element?.id as Int

        val name: String = set.name()

        val coordinates = Coordinates(set.coordinateX(),set.coordinateY())

        val creationDate = Date()

        val height = set.height()

        val weight = set.weight()

        val hairColor = set.hairColor()

        val nationality = set.nationality()

        val location = Location(set.locationX(), set.locationY(), set.locationZ())
        collectionManager.getVector().elementAt(id)
        element = Person(id, name, coordinates, creationDate, height, weight, hairColor, nationality, location)
    }
}
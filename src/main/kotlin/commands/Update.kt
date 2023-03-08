package commands

import data.Coordinates
import data.Location
import data.Person
import org.jetbrains.kotlin.konan.file.File
import utils.AddPersonFields
import utils.CollectionManager
import utils.PrinterManager
import java.util.*

/**
 * Updates element of collection with inputed id.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Update: Command <Int> {
    private val set = AddPersonFields()
    private val writeToConsole = PrinterManager()

    override fun execute(args: Array<Any>, collectionManager: CollectionManager) {
        var id = 0
        var element: Person? = null
        var params = arrayListOf<String>("null parameter", "null parameter", "null parameter", "null parameter", "null parameter",
                                         "null parameter", "null parameter", "null parameter", "null parameter", "null parameter")
        val flag = args[0] as String

        if (flag != "main") {
            params = parametersParser(args)
        }

        try {
            for (obj in collectionManager.getVector()) {
                if (obj.id == args[0]) {
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
            writeToConsole.writelnInConsole("Элемента с указанным id не существует")
            return
        }

        val name = set.name(params[0], flag)

        val coordinates = Coordinates(set.coordinateX(params[1], flag), set.coordinateY(params[2], flag))

        val creationDate = Date()

        val height = set.height(params[3], flag)

        val weight = set.weight(params[4], flag)

        val hairColor = set.hairColor(params[5], flag)

        val nationality = set.nationality(params[6], flag)

        val location = Location(set.locationX(params[7], flag), set.locationY(params[8], flag), set.locationZ(params[9], flag))

        element = Person(id, name, coordinates, creationDate, height, weight, hairColor, nationality, location)
        collectionManager.getVector().removeAt(id-1)
        collectionManager.getVector().insertElementAt(element, id-1)
    }

    private fun parametersParser (args: Array<Any>): ArrayList<String> {
        val flag = args[0] as String
        val path = args[1] as String
        val params = arrayListOf<String>()
        var isAdd = false
        var counter = 0
        val strings = File(path).readStrings()

        strings.forEach {
            if (!isAdd || counter < 10) {
                isAdd = false
                if (it == "add") {
                    isAdd = true
                    counter = 0
                }
            } else {
                params.add(it.lowercase())
                counter++
            }
        }
        return params
    }
}
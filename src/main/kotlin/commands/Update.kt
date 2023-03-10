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
        var params = arrayListOf("null parameter", "null parameter", "null parameter", "null parameter", "null parameter",
                                         "null parameter", "null parameter", "null parameter", "null parameter", "null parameter")
        var flag = "null"

        if (args.size == 2) {
            flag = args[1] as String
        } else {
            args[2] as String
        }

        args.forEach { println(it) }

        if (flag != "main") {
            params = parametersParser(args)
        }

        try {
            for (obj in collectionManager.getVector()) {
                if (obj.id == args[0].toString().toInt()) {
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

        println(params)
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
        val path = args[1] as String
        val params = arrayListOf<String>()
        val strings = File(path).readStrings()
        args.forEach { println(it) }

        for (id in 0 until strings.size) {
            if (strings[id] == ("update ${args[0]}")) {
                for (n in 1..10) {
                    params.add(strings[id + n].lowercase().trim())
                }
            }
        }
        return params
    }
}
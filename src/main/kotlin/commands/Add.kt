package commands

import data.Coordinates
import data.Location
import data.Person
import org.jetbrains.kotlin.konan.file.File
import utils.AddPersonFields
import java.util.*

/**
 * Adds new element in collection.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Add: Command() {
    private val set = AddPersonFields()

    override fun execute(args: Map<String, Any>) {
        val flag = args.get("flag") as String
        val rawParams = args.get("params") as Array<*>
        val id: Int = collectionManager.getVector().maxOf { it.id } + 1
        var params = arrayListOf("null parameter", "null parameter", "null parameter", "null parameter", "null parameter",
                                         "null parameter", "null parameter", "null parameter", "null parameter", "null parameter")

        if (flag != "main") {
            params = parametersParser(rawParams)
        }

        try {
        val name = set.name(params[0], flag)

        val coordinates = Coordinates(set.coordinateX(params[1], flag), set.coordinateY(params[2], flag))

        val creationDate = Date()

        val height = set.height(params[3], flag)

        val weight = set.weight(params[4], flag)

        val hairColor = set.hairColor(params[5], flag)

        val nationality = set.nationality(params[6], flag)

        val location = Location(set.locationX(params[7], flag), set.locationY(params[8], flag), set.locationZ(params[9], flag))

        val personElement =
            Person(id, name, coordinates, creationDate, height, weight, hairColor, nationality, location)
        collectionManager.addObject(personElement)
        } catch (e: IndexOutOfBoundsException) {
            write.linesInConsole(message.getMessage("not_enough_args"))
            return
        }
        write.linesInConsole(message.getMessage("added"))
    }

    private fun parametersParser (args: Array<*>): ArrayList<String> {
        val path = args[0] as String
        val params = arrayListOf<String>()
        val strings = File(path).readStrings()

        for (id in 0 until strings.size) {
            if (strings[id] == "add") {
                for (n in 1..10) {
                    params.add(strings[id + n].lowercase().trim())
                }
            }
        }
        return params
    }
}

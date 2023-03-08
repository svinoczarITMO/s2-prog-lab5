package commands

import data.Coordinates
import data.Location
import data.Messages
import data.Person
import org.jetbrains.kotlin.konan.file.File
import utils.AddPersonFields
import utils.CollectionManager
import utils.PrinterManager
import java.util.*

/**
 * Adds new element in collection.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Add: Command <String>{
    private val set = AddPersonFields()
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(args: Array<Any>, collectionManager: CollectionManager) {
        val id: Int = collectionManager.getVector().size + 1
        var flag = "null"
        var params = arrayListOf("null parameter", "null parameter", "null parameter", "null parameter", "null parameter",
                                         "null parameter", "null parameter", "null parameter", "null parameter", "null parameter")

        if (args.size == 1) {
            flag = args[0] as String
        } else {
            args[1] as String
        }

        if (flag != "main") {
            params = parametersParser(args)
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
            writeToConsole.writelnInConsole("Не хватает параметров в скрипте для добавления новой команды.")
            return
        }
    }

    private fun parametersParser (args: Array<Any>): ArrayList<String> {
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
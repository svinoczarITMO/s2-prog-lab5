package commands

import data.Coordinates
import data.Location
import data.Person
import org.jetbrains.kotlin.konan.file.File
import utils.AddPersonFields
import utils.CollectionManager
import utils.Validator
import java.util.*

/**
 * Adds new element in collection.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Add: Command <String>{
    private val set = AddPersonFields()
    private val validator = Validator()

    override fun execute(args: Array<Any>, collectionManager: CollectionManager) {
        val id: Int = collectionManager.getVector().size + 1
        var params = arrayListOf<String>()
        val flag = args[0] as String

        if (flag != "main") {
            params = parametrsParser(args)
        }


        val name: String = set.name(params[0], flag)

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
    }

    private fun parametrsParser (args: Array<Any>): ArrayList<String> {
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
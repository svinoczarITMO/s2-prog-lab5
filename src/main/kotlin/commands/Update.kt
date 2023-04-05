package commands

import data.Coordinates
import data.Location
import data.Person
import org.jetbrains.kotlin.konan.file.File
import utils.AddPersonFields
import utils.PrinterManager
import java.util.*

/**
 * Updates element of collection with inputed id.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Update: Command() {
    private val set = AddPersonFields()
    private val writeToConsole = PrinterManager()
    override fun getName(): String {
        return "update"
    }

    override fun getDescription(): String {
        return getName() + " - обновляет элемент коллекции по указанному id\n"
    }

    override fun execute(args: Map<String, Any?>) {
        val elementId = if (args.contains("elementId")) args["elementId"] as Int else 0
        val path = if (args.contains("path")) args["path"] as String else ""
        val flag = if (args.contains("flag")) args["flag"] as String else ""
        val id: Int
        var element: Person? = null
        val tmpMap = mutableMapOf<String, Any>()
        var params = arrayListOf("null parameter", "null parameter", "null parameter", "null parameter", "null parameter",
                                         "null parameter", "null parameter", "null parameter", "null parameter", "null parameter")

        tmpMap["path"] = path
        tmpMap["elementId"] = elementId

        if (flag != "main") {
            params = parametersParser(tmpMap)
        }

        try {
            for (obj in collectionManager.collection) {
                if (obj.id == args["elementId"]) {
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
            writeToConsole.linesInConsole("Элемента с указанным id не существует")
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

//        val iterator = collectionManager.collection.iterator()
//        while (iterator.hasNext()) {
//            val el = iterator.next()
//            if (el.id == id) {
//                iterator.remove()
//            }
//        }

//        for (el in collectionManager.collection) {
//            if (count != id) {
//                println(el)
//                println("------")
//                bufferCollection.add(el)
//                println(bufferCollection)
//                count++
//            } else {
//                bufferCollection.add(element)
//                count++
//            }
//        }

        val bufferCollection = mutableListOf<Person>()
        for (el in collectionManager.collection) {
            if (el.id != element.id) {
                bufferCollection.add(el)
            } else {
                bufferCollection.add(element)
            }
        }
        collectionManager.collection = bufferCollection
    }

    private fun parametersParser (args: Map<String, Any>): ArrayList<String> {
        val path: String by args
        val id: Int by args
        val params = arrayListOf<String>()
        val strings = File(path).readStrings()

        for (index in 0 until strings.size) {
            if (strings[index] == ("update $id")) {
                for (n in 1..10) {
                    params.add(strings[index + n].lowercase().trim())
                }
            }
        }
        return params
    }
}
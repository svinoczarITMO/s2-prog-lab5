package commands

import utils.CollectionController
import data.Color
import data.Coordinates
import data.Country
import data.Location
import data.Person
import java.util.*

class Add: Command {
    var collectionController: CollectionController = CollectionController()

    fun addNewElement() {
        val id: Int = collectionController.vector.size + 1

        print("Введите имя: ");
        val name: String = readln()

        val s: MutableMap<String,String> = mutableMapOf()

        val coordinateX: Float = readln().toFloat()
        print("Введите координату y места рождения: ");
        val coordinateY: Float = readln().toFloat()
        val coordinates: Coordinates = Coordinates(coordinateX, coordinateY)

        val creationDate: Date = Date()

        print("Введите рост: ");
        val height: Int = readln().toInt()

        print("Введите вес: ");
        val weight: Long = readln().toLong()

        print("Выберите цвет волос из предложенных: ")
        for (value in Color.values()) {
            print(value.toString() + ", ")
        }
        println()
        val hairColor: Color = Color.valueOf(readln().uppercase())

        print("Выберите страну рождения из предложенных: ")
        for (value in Country.values()) {
            print(value.toString() + ", ")
        }
        println()
        val nationality: Country = Country.valueOf(readln().uppercase())

        print("Введите координату x примерного текущего местоположения: ");
        var locationX: Int = readln().toInt()
        print("Введите координату y примерного текущего местоположения: ");
        var locationY: Long = readln().toLong()
        print("Введите координату z примерного текущего местоположения: ");
        var locationZ: Int = readln().toInt()
        var location: Location = Location(locationX, locationY, locationZ)

        var personElement: Person =
            Person(id, name, coordinates, creationDate, height, weight, hairColor, nationality, location)

        collectionController.getVector().add(personElement)
    }
}
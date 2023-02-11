package commands

import controllers.CollectionController
import data.Color
import data.Coordinates
import data.Country
import data.Location
import data.Person
import java.util.*

class Add {
    fun addNewElement() {
        var id: Int = CollectionController.vector.size + 1

        print("Введите имя: ");
        var name: String = readln()

        val s: MutableMap<String,String> = mutableMapOf()

        var coordinateX: Float = readln().toFloat()
        print("Введите координату y места рождения: ");
        var coordinateY: Float = readln().toFloat()
        var coordinates: Coordinates = Coordinates(coordinateX, coordinateY)

        var creationDate: Date = Date()

        print("Введите рост: ");
        var height: Int = readln().toInt()

        print("Введите вес: ");
        var weight: Long = readln().toLong()

        print("Выберите цвет волос из предложенных: ")
        for (value in Color.values()) {
            print(value.toString() + ", ")
        }
        println()
        var hairColor: Color = Color.valueOf(readln().uppercase())

        print("Выберите страну рождения из предложенных: ")
        for (value in Country.values()) {
            print(value.toString() + ", ")
        }
        println()
        var nationality: Country = Country.valueOf(readln().uppercase())

        data =

        print("Введите координату x примерного текущего местоположения: ");
        var locationX: Int = readln().toInt()
        print("Введите координату y примерного текущего местоположения: ");
        var locationY: Long = readln().toLong()
        print("Введите координату z примерного текущего местоположения: ");
        var locationZ: Int = readln().toInt()
        var location: Location = Location(locationX, locationY, locationZ)

        var personElement: Person =
            Person(id, name, coordinates, creationDate, height, weight, hairColor, nationality, location)

        CollectionController.addElement(personElement)
    }
}
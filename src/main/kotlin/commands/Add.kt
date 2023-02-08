package commands

import Color
import Coordinates
import Country
import Location
import Person
import java.util.*

class Add {
    companion object {
        fun addNewElement() {
            var id: Int = CollectionController.vector.size + 1

            print("Введите имя: ");
            var name: String = readln()

            print("Введите координату x: ");
            var coordinateX: Float = readln().toFloat()
            print("Введите координату y: ");
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

            print("Введите координату x: ");
            var locationX: Int = readln().toInt()
            print("Введите координату y: ");
            var locationY: Long = readln().toLong()
            print("Введите координату z: ");
            var locationZ: Int = readln().toInt()
            var location: Location = Location(locationX, locationY, locationZ)

            var personElement: Person =
                Person(id, name, coordinates, creationDate.toString(), height, weight, hairColor, nationality, location)

            CollectionController.addElement(personElement)
        }
    }
}
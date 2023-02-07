package commands

import CollectionController
import Color
import Country
import Location
import Person
import java.util.*

class Update {
    companion object {
        fun updateElement(id: Int) {
            var element: Person = CollectionController.vector.elementAt(id - 1)

            print("Введите новое имя: ");
            element.name = readln()

            print("Введите новую координату x: ");
            element.coordinates.x = readln().toFloat()
            print("Введите новую координату y: ");
            element.coordinates.y = readln().toFloat()

            //element.creationDate = Date() TODO: дата создания обновляется?

            print("Введите новый рост: ");
            element.height = readln().toInt()

            print("Введите новый вес: ");
            element.weight = readln().toLong()

            print("Выберите новый цвет волос из предложенных: ")
            for (value in Color.values()) {
                print(value.toString() + ", ")
            }
            println()
            element.hairColor = Color.valueOf(readln().uppercase())

            print("Выберите новую страну рождения из предложенных: ")
            for (value in Country.values()) {
                print(value.toString() + ", ")
            }
            println()
            element.nationality = Country.valueOf(readln().uppercase())

            print("Введите новую координату x: ");
            element.location.x = readln().toInt()
            print("Введите новую координату y: ");
            element.location.y = readln().toLong()
            print("Введите новую координату z: ");
            element.location.z = readln().toInt()
        }
    }
}
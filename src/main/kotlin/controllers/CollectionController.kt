package controllers

import data.Person
import java.util.Vector

//koin
class CollectionController {
    var vector = Vector<Person>()

    var reflexVector = ::vector
    var type = reflexVector.returnType
    var accessability = reflexVector.isOpen


    fun addElement(element: Person) {
        vector.add(element)
    }

    fun getElement (id: Int) { //TODO сделать через рефлексию (?)
        val obj = vector[id]
        println("Объект ${obj.id}:\n"
        + "Дата создания: \"" + obj.creationDate + "\" \n"
        + "Координаты: x = " + obj.coordinates.x + " y = " + obj.coordinates.y + "\n"
        + "Имя: " + obj.name + "\n"
        + "Рост: " + obj.height + "\n"
        + "Вес: " + obj.weight + "\n"
        + "Цвет волос: " + obj.hairColor + "\n"
        + "Национальность: " + obj.nationality + "\n"
        + "Местоположение: x = " + obj.location.x + "; y = " + obj.location.y + "; z = " + obj.location.z + "\n")
    }


    fun clear () {
        vector.clear()
    }

    fun removeById (id: Int) {
        vector.removeAt(id-1)
    }

    fun removeFirst () {
        vector.removeFirst()
    }

    fun reorder () {
        var bufferVector: Vector<Person> = Vector()
        for (element in vector) {
            bufferVector.insertElementAt(element,0)
        }
        vector = bufferVector
    }
}
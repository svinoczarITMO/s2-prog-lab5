package controllers

import controllers.CollectionController
import data.*
import java.util.Date
import java.util.Vector
import kotlin.system.exitProcess

class CommandController {
    var collectionController: CollectionController = CollectionController()
    /**
        Функции разработчика (отладка):

        /print - выводит в стандартный поток вывода коллекцию "vector"
        /get - выводит в стандартный поток вывода элемент коллекции "vector" с индексом "index"
        /fadd - добавляет зараннее созданный объект .data.Person в "vector"
    */
    fun prnt () {
        println(collectionController.vector)
    }
    fun get (index: Int) {
        collectionController.getElement(index-1)
    }
    fun fadd () {
        var id: Int = collectionController.vector.size + 1001
        var obj: Person = Person(id, "Jesus", Coordinates(0f,0f), Date(), 305, 0, Color.RED, Country.USA, Location(0,0,0))
        collectionController.vector.add(obj)
    }

    /** __(~_~)-- **/

    fun executeScript(fileName: String) {}
    fun exit () {
        exitProcess(0)
    }
}
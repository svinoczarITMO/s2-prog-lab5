package utils

import commands.*
import data.*
import java.util.Date
import kotlin.system.exitProcess

class CommandManager {

    val commands = mapOf<String, Command>(
        "help" to Help(),
        "info" to Info(),
        "show" to Show(),
        "add" to Add(),
        "update" to Update(),
        "remove_by_id" to RemoveByID(),
        "clear" to Clear(),
        "save" to Save(),
        "execute_script" to ExecuteScript(),
        "exit" to Exit(),
        "remove_first" to RemoveFirst(),
        "reorder" to Reorder(),
        "history" to History(),
        "min_by_weight" to MinByWeight(),
        "group_counting_by_nationality" to GroupCountingByNationality(),
        "count_by_hair_color" to CountByHairColor()
    )





    var collectionManager: CollectionManager = CollectionManager()
    /**
        Функции разработчика (отладка):

        print - выводит в стандартный поток вывода коллекцию "vector"
        get - выводит в стандартный поток вывода элемент коллекции "vector" с индексом "index"
        fadd - добавляет зараннее созданный объект .data.Person в "vector"
    */
    fun prnt () {
        println(collectionManager.vector)
    }
    fun get (index: Int) {
        collectionManager.getElement(index-1)
    }
    fun fadd () {
        var id: Int = collectionManager.vector.size + 1001
        var obj: Person = Person(id, "Jesus", Coordinates(0f,0f), Date(), 305, 0, Color.RED, Country.USA, Location(0,0,0))
        collectionManager.vector.add(obj)
    }

    /** __(~_~)-- **/

    fun executeScript(fileName: String) {}
    fun exit () {
        exitProcess(0)
    }
}
import java.util.Date
import kotlin.system.exitProcess

class CommandController {
    companion object {
        /**
            Функции разработчика (отладка):
            /print - выводит в стандартный поток вывода коллекцию "vector"
            /get - выводит в стандартный поток вывода элемент коллекции "vector" с индексом "index"
            /fadd - добавляет зараннее созданный объект .Person в "vector"
        */
        fun prnt () {
            println(CollectionController.vector)
        }
        fun get (index: Int) {
            CollectionController.getElement(index-1)
        }
        fun fadd () {
            var id: Int = CollectionController.vector.size + 1001
            var obj: Person = Person(id, "Jesus", Coordinates(0f,0f), Date(), 305, 0, Color.RED, Country.USA, Location(0,0,0))
            CollectionController.addElement(obj)
        }

        /** __(~_~)-- **/

        fun help () {} //TODO: убрать (?)
        fun info () {} //TODO: убрать (?)
        fun show () {}
        fun update (id: Int) {
            print("Введите значение элемента: ")
            var element = readln()
        }
        fun removeById (id: Int) {}
        fun save () {}
        fun executeScript(fileName: String) {}
        fun exit () {
            exitProcess(0)
        }
        fun removeFirst () {}
        fun reorder () {}
        fun history () {} //TODO убрать (?)
        fun minByWeight () {}
        fun groupCountingByNationality () {}
        fun countByHairColor () {}

    }


}
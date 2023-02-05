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
            CollectionController.getElement(index)
        }
        fun fadd () {
            var id: Int = 1000
            var obj: Person = Person(id, "Jesus", Coordinates(0f,0f), Date(), 305, 0, Color.RED, Country.USA, Location(0,0,0))
            CollectionController.addElement(obj)
            id++
        }

        /** __(~_~)-- **/

        fun help () {}
        fun info () {}
        fun show () {}
        fun add () {
            var id: Int = 1

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
                print(value.toString() + ", " )
            }
            println()
            var hairColor: Color = Color.valueOf(readln().uppercase())

            print("Выберите страну рождения из предложенных: ")
            for (value in Country.values()) {
                print(value.toString() + ", " )
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

            var personElement: Person = Person(id, name, coordinates, creationDate, height, weight, hairColor, nationality, location)
            CollectionController.addElement(personElement)

            id++
        }
        fun update (id: Int) {
            print("Введите значение элемента: ")
            var element = readln()
        }
        fun removeById (id: Int) {}
        fun clear () {}
        fun save () {}
        fun executeScript(fileName: String) {}
        fun exit () {
            exitProcess(0)
        }
        fun removeFirst () {}
        fun recorder () {}
        fun history () {}
        fun minByWeight () {}
        fun groupCountingByNationality () {}
        fun countByHairColor () {}

    }

}
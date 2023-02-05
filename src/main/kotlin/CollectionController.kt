import java.util.Vector

class CollectionController {

    companion object {
        var vector = Vector<Person>()

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
            + "Национальность: " + obj.nationality
            + "Местоположение: x = " + obj.location.x + "; y = " + obj.location.y + "; z = " + obj.location.z + "\n")

        }
    }
}
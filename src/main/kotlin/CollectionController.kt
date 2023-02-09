import java.util.Vector


class CollectionController {
    companion object {
        var vector = Vector<Person>()

        private var reflexVector = ::vector
        private var type = reflexVector.returnType
        private var accessability = reflexVector.isOpen


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

        fun printInfo () {
            println(
               type.toString().split(".")[2] + ", "
               + "Размер: " + vector.size + ", "
               + when { accessability.toString() == "false, " -> "close"
                   else -> "open, " } )
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

}
import commands.Info
import java.util.Vector
import kotlin.reflect.full.instanceParameter
import kotlin.reflect.full.valueParameters

class CollectionController {

    companion object {
        var vector = Vector<Person>()
        private var reflexVector = ::vector
        private var type = reflexVector.returnType
        private var accessability = reflexVector.isOpen
        private var annotations = reflexVector.annotations
        private var param = reflexVector.parameters
        private var typeParam = reflexVector.typeParameters
        private var paramm = reflexVector.instanceParameter

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
        fun printInfo () {
            println(
               type.toString().split(".")[2] + ", "
               + "Размер: " + vector.size + ", "
               + when { accessability.toString() == "false, " -> "close"
                   else -> "open, " }
               + annotations.toString() + ", "
               + param.toString() + ", "
               + typeParam.toString() + ", "
               + param.toString() + ", "
               + paramm.toString())
        }
    }
}
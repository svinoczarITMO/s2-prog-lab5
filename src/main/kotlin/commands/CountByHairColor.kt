package commands

import data.Color
import utils.CollectionManager

class CountByHairColor: Command {
    fun countByHairColor (color: String) {
        val copyVector = CollectionManager().getVector()
        var counter: Int = 0
        for (element in copyVector) {
            if (element.hairColor == Color.valueOf(color.uppercase())) {
                counter += 1
        }
    }
        println("Количество людей с цветом волос \"${color.capitalize()}\": $counter")

    }

    override fun execute(command: String) {
        TODO("Not yet implemented")
    }
}
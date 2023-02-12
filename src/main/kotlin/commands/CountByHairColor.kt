package commands

import utils.CollectionController
import data.Color

class CountByHairColor: Command {
    fun countByHairColor (color: String) {
        val copyVector = CollectionController.vector
        var counter: Int = 0
        for (element in copyVector) {
            if (element.hairColor == Color.valueOf(color.uppercase())) {
                counter += 1
        }
    }
        println("Количество людей с цветом волос \"${color.capitalize()}\": $counter")

    }
}
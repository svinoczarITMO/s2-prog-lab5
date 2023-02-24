package utils

import data.Color
import data.Country
import data.Messages
import exceptions.ElementAmountException

class AddPersonFields {
    private val writeToConsole = PrinterManager()
    private val readerManager = ReaderManager()
    private val message = Messages()

    fun name (): String {
        writeToConsole.writelnToConsole(message.getMessage("enter_name"))
        val name = readerManager.readFromConsole()
        try {
            if (name.isBlank()) throw ElementAmountException()
            return name
        } catch (e: ElementAmountException) {
            writeToConsole.writelnToConsole("Строка не может быть пустой! Введите имя ещё раз.")
        }
        return name()
    }

    fun coordinateX (): Float {
        writeToConsole.writelnToConsole(message.getMessage("enter_coordinateX"))
        val coordinateX = readerManager.readFromConsole()
        try {
            return coordinateX.toFloat()
        } catch (e: NumberFormatException) {
            writeToConsole.writelnToConsole(message.getMessage("NumberFormatException"))
        }
        return coordinateX()
    }

    fun coordinateY (): Float {
        writeToConsole.writelnToConsole(message.getMessage("enter_coordinateY"))
        val coordinateY = readerManager.readFromConsole()
        try {
            return coordinateY.toFloat()
        } catch (e: NumberFormatException) {
            writeToConsole.writelnToConsole(message.getMessage("NumberFormatException"))
        }
        return coordinateY()
    }

    fun height (): Int {
        writeToConsole.writelnToConsole(message.getMessage("enter_height"))
        val height = readerManager.readFromConsole()
        try {
            return height.toInt()
        } catch (e: NumberFormatException) {
            writeToConsole.writelnToConsole(message.getMessage("NumberFormatException"))
        }
        return height()
    }

    fun weight (): Long {
        writeToConsole.writelnToConsole(message.getMessage("enter_weight"))
        val weight = readerManager.readFromConsole()
        try {
            return weight.toLong()
        } catch (e: NumberFormatException) {
            writeToConsole.writelnToConsole(message.getMessage("NumberFormatException"))
        }
        return weight()
    }

    fun hairColor (): Color {
        writeToConsole.writelnToConsole(message.getMessage("enter_hairColor"))
        for (value in 0 until Color.values().size) {
            writeToConsole.writeToConsole("${Color.values()[value]}")
            if (value < Color.values().size-1) {
                writeToConsole.writeToConsole(", ")
            }
        }
        writeToConsole.writelnToConsole("")
        val hairColor = readerManager.readFromConsole().uppercase()
        try {
            return Color.valueOf(hairColor)
        } catch (e: IllegalArgumentException) {
            writeToConsole.writelnToConsole(message.getMessage("IllegalColor"))
        }
        return hairColor()
    }

    fun nationality (): Country {
        writeToConsole.writelnToConsole(message.getMessage("enter_nationality"))
        for (value in 0 until Country.values().size) {
            writeToConsole.writeToConsole("${Country.values()[value]}")
            if (value < Country.values().size-1) {
                writeToConsole.writeToConsole(",")
            }
        }
        writeToConsole.writelnToConsole("")
        val nationality = readerManager.readFromConsole().uppercase()
        try {
            return Country.valueOf(nationality)
        } catch (e: IllegalArgumentException) {
            writeToConsole.writelnToConsole(message.getMessage("IllegalCountry"))
        }
        return nationality()
    }

    fun locationX (): Int {
        writeToConsole.writelnToConsole(message.getMessage("enter_locationX"))
        val locationX = readerManager.readFromConsole()
        try {
            return locationX.toInt()
        } catch (e: NumberFormatException) {
            writeToConsole.writelnToConsole(message.getMessage("NumberFormatException"))
        }
        return locationX()
    }

    fun locationY (): Long {
        writeToConsole.writelnToConsole(message.getMessage("enter_locationY"))
        val locationY = readerManager.readFromConsole()
        try {
            return locationY.toLong()
        } catch (e: NumberFormatException) {
            writeToConsole.writelnToConsole(message.getMessage("NumberFormatException"))
        }
        return locationY()
    }

    fun locationZ (): Int {
        writeToConsole.writelnToConsole(message.getMessage("enter_locationZ"))
        val locationZ = readerManager.readFromConsole()
        try {
            return locationZ.toInt()
        } catch (e: NumberFormatException) {
            writeToConsole.writelnToConsole(message.getMessage("NumberFormatException"))
        }
        return locationZ()
    }
}
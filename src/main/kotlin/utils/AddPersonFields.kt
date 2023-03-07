package utils

import data.Color
import data.Country
import data.Messages
import exceptions.ElementAmountException

/**
 * Handles inputed data for Person constructor fields.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class AddPersonFields {
    private val writeToConsole = PrinterManager()
    private val readerManager = ReaderManager()
    private val message = Messages()

    /**
     * Sets inputed name of current Person element.
     *
     * @return name as String
     */
    fun name (): String {
        writeToConsole.writelnInConsole(message.getMessage("enter_name"))
        val name = readerManager.readFromConsole()
        try {
            if (name.isBlank()) throw ElementAmountException()
            return name
        } catch (e: ElementAmountException) {
            writeToConsole.writelnInConsole("Строка не может быть пустой! Введите имя ещё раз.")
        }
        return name()
    }

    /**
     * Sets inputed coordinate "x" of current Person element.
     *
     * @return Float
     */
    fun coordinateX (): Float {
        writeToConsole.writelnInConsole(message.getMessage("enter_coordinateX"))
        val coordinateX = readerManager.readFromConsole()
        try {
            if (coordinateX <= 214.toString()) {
                //TODO: сравнивать флоат, а не стринг
                return coordinateX.toFloat()
            } else {
                writeToConsole.writelnInConsole("Координата \"x\" должна быть не больше 214!")
                return coordinateX()
            }
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return coordinateX()
    }

    /**
     * Sets inputed coordinate "x" of current Person element.
     *
     * @return Float
     */
    fun coordinateY (): Float {
        writeToConsole.writelnInConsole(message.getMessage("enter_coordinateY"))
        val coordinateY = readerManager.readFromConsole()
        try {
            if (coordinateY <= 794.toString()) {
                return coordinateY.toFloat()
            } else {
                writeToConsole.writelnInConsole("Координата \"y\" должна быть не больше 794!")
                return coordinateY()
            }
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return coordinateY()
    }

    /**
     * Sets inputed height of current Person element.
     *
     * @return Int
     */
    fun height (): Int {
        writeToConsole.writelnInConsole(message.getMessage("enter_height"))
        val height = readerManager.readFromConsole()
        try {
            if (height > 0.toString()) {
                return height.toInt()
            } else {
                writeToConsole.writelnInConsole("Рост должен быть больше нуля!")
                return height()
            }
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return height()
    }

    /**
     * Sets inputed weight of current Person element.
     *
     * @return Long
     */
    fun weight (): Long {
        writeToConsole.writelnInConsole(message.getMessage("enter_weight"))
        val weight = readerManager.readFromConsole()
        try {
            if (weight > 0.toString()) {
                return weight.toLong()
            } else {
                writeToConsole.writelnInConsole("Вес должен быть больше нуля!")
                return weight()
            }
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return weight()
    }

    /**
     * Sets inputed color of hair of current Person element.
     *
     * @return Color
     */
    fun hairColor (): Color {
        writeToConsole.writelnInConsole(message.getMessage("enter_hairColor"))
        for (value in 0 until Color.values().size) {
            writeToConsole.writeInConsole("${Color.values()[value]}")
            if (value < Color.values().size-1) {
                writeToConsole.writeInConsole(", ")
            }
        }
        writeToConsole.writelnInConsole("")
        val hairColor = readerManager.readFromConsole().uppercase()
        try {
            return Color.valueOf(hairColor)
        } catch (e: IllegalArgumentException) {
            writeToConsole.writelnInConsole(message.getMessage("IllegalColor"))
        }
        return hairColor()
    }

    /**
     * Sets inputed nationality of current Person element.
     *
     * @return Country
     */
    fun nationality (): Country {
        writeToConsole.writelnInConsole(message.getMessage("enter_nationality"))
        for (value in 0 until Country.values().size) {
            writeToConsole.writeInConsole("${Country.values()[value]}")
            if (value < Country.values().size-1) {
                writeToConsole.writeInConsole(",")
            }
        }
        writeToConsole.writelnInConsole("")
        val nationality = readerManager.readFromConsole().uppercase()
        try {
            return Country.valueOf(nationality)
        } catch (e: IllegalArgumentException) {
            writeToConsole.writelnInConsole(message.getMessage("IllegalCountry"))
        }
        return nationality()
    }

    /**
     * Sets inputed location "x" of current Person element.
     *
     * @return Int
     */
    fun locationX (): Int {
        writeToConsole.writelnInConsole(message.getMessage("enter_locationX"))
        val locationX = readerManager.readFromConsole()
        try {
            return locationX.toInt()
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return locationX()
    }

    /**
     * Sets inputed location "y" of current Person element.
     *
     * @return Long
     */
    fun locationY (): Long? {
        writeToConsole.writelnInConsole(message.getMessage("enter_locationY"))
        val locationY = readerManager.readFromConsole()
        try {
            return locationY?.toLong()
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return locationY()
    }

    /**
     * Sets inputed location "z" of current Person element.
     *
     * @return Int
     */
    fun locationZ (): Int {
        writeToConsole.writelnInConsole(message.getMessage("enter_locationZ"))
        val locationZ = readerManager.readFromConsole()
        try {
            return locationZ.toInt()
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return locationZ()
    }
}
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
    fun name (flag: String, arg: String?): String {
        val name: String = if (flag == "main") {
            writeToConsole.writelnInConsole(message.getMessage("enter_name"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }

        try {
            if (name.isBlank()) throw ElementAmountException()
            return name
        } catch (e: ElementAmountException) {
            writeToConsole.writelnInConsole("Строка не может быть пустой! Введите имя ещё раз.")
        }
        return name(flag, arg)
    }

    /**
     * Sets inputed coordinate "x" of current Person element.
     *
     * @return Float
     */
    fun coordinateX (flag: String, arg: String?): Float {
        val coordinateX: String = if (flag == "main") {
            writeToConsole.writelnInConsole(message.getMessage("enter_coordinateX"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }
        try {
            if (coordinateX.toFloat() <= 214) {
                //TODO: сравнивать флоат, а не стринг
                return coordinateX.toFloat()
            } else {
                writeToConsole.writelnInConsole("Координата \"x\" должна быть не больше 214!")
                return coordinateX(flag, arg)
            }
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return coordinateX(flag, arg)
    }

    /**
     * Sets inputed coordinate "x" of current Person element.
     *
     * @return Float
     */
    fun coordinateY (flag: String, arg: String?): Float {
        val coordinateY: String = if (flag == "main") {
            writeToConsole.writelnInConsole(message.getMessage("enter_coordinateY"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }
        try {
            if (coordinateY.toFloat() <= 794) {
                return coordinateY.toFloat()
            } else {
                writeToConsole.writelnInConsole("Координата \"y\" должна быть не больше 794!")
                return coordinateY(flag, arg)
            }
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return coordinateY(flag, arg)
    }

    /**
     * Sets inputed height of current Person element.
     *
     * @return Int
     */
    fun height (flag: String, arg: String?): Int {
        val height: String = if (flag == "main") {
            writeToConsole.writelnInConsole(message.getMessage("enter_height"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }
        try {
            if (height.toInt() > 0) {
                return height.toInt()
            } else {
                writeToConsole.writelnInConsole("Рост должен быть больше нуля!")
                return height(flag, arg)
            }
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return height(flag, arg)
    }

    /**
     * Sets inputed weight of current Person element.
     *
     * @return Long
     */
    fun weight (flag: String, arg: String?): Long {
        val weight: String = if (flag == "main") {
            writeToConsole.writelnInConsole(message.getMessage("enter_weight"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }
        try {
            if (weight.toLong() > 0) {
                return weight.toLong()
            } else {
                writeToConsole.writelnInConsole("Вес должен быть больше нуля!")
                return weight(flag, arg)
            }
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return weight(flag, arg)
    }

    /**
     * Sets inputed color of hair of current Person element.
     *
     * @return Color
     */
    fun hairColor (flag: String, arg: String?): Color {
        val hairColor: String = if (flag == "main") {
            writeToConsole.writelnInConsole(message.getMessage("enter_hairColor"))
            for (value in 0 until Color.values().size) {
                writeToConsole.writeInConsole("${Color.values()[value]}")
                if (value < Color.values().size-1) {
                    writeToConsole.writeInConsole(", ")
                }
            }
            writeToConsole.writelnInConsole("")
            readerManager.readFromConsole().uppercase()
        } else {
            arg?.uppercase() as String
        }
        try {
            return Color.valueOf(hairColor)
        } catch (e: IllegalArgumentException) {
            writeToConsole.writelnInConsole(message.getMessage("IllegalColor"))
        }
        return hairColor(flag, arg)
    }

    /**
     * Sets inputed nationality of current Person element.
     *
     * @return Country
     */
    fun nationality (flag: String, arg: String?): Country {

        writeToConsole.writelnInConsole("")
        val nationality: String = if (flag == "main") {
            writeToConsole.writelnInConsole(message.getMessage("enter_nationality"))
            for (value in 0 until Country.values().size) {
                writeToConsole.writeInConsole("${Country.values()[value]}")
                if (value < Country.values().size-1) {
                    writeToConsole.writeInConsole(",")
                }
            }
            writeToConsole.writelnInConsole("")
            readerManager.readFromConsole().uppercase()
        } else {
            arg?.uppercase() as String
        }
        try {
            return Country.valueOf(nationality)
        } catch (e: IllegalArgumentException) {
            writeToConsole.writelnInConsole(message.getMessage("IllegalCountry"))
        }
        return nationality(flag, arg)
    }

    /**
     * Sets inputed location "x" of current Person element.
     *
     * @return Int
     */
    fun locationX (flag: String, arg: String?): Int {
        val locationX: String = if (flag == "main") {
            writeToConsole.writelnInConsole(message.getMessage("enter_locationX"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }
        try {
            return locationX.toInt()
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return locationX(flag, arg)
    }

    /**
     * Sets inputed location "y" of current Person element.
     *
     * @return Long
     */
    fun locationY (flag: String, arg: String?): Long? {
        val locationY: String = if (flag == "main") {
            writeToConsole.writelnInConsole(message.getMessage("enter_locationY"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }
        try {
            return locationY?.toLong()
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return locationY(flag, arg)
    }

    /**
     * Sets inputed location "z" of current Person element.
     *
     * @return Int
     */
    fun locationZ (flag: String, arg: String?): Int {
        val locationZ: String = if (flag == "main") {
            writeToConsole.writelnInConsole(message.getMessage("enter_locationZ"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }
        try {
            return locationZ.toInt()
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return locationZ(flag, arg)
    }
}
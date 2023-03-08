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
    fun name (arg: String?, flag: String): String {
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
        return name(arg, flag)
    }

    /**
     * Sets inputed coordinate "x" of current Person element.
     *
     * @return Float
     */
    fun coordinateX (arg: String?, flag: String): Float {
        val coordinateX: String = if (flag == "main") {
            writeToConsole.writelnInConsole(message.getMessage("enter_coordinateX"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }
        try {
            if (coordinateX.toFloat() <= 214) {
                return coordinateX.toFloat()
            } else {
                writeToConsole.writelnInConsole("Координата \"x\" должна быть не больше 214!")
                return coordinateX(arg, flag)
            }
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        //TODO????
        return coordinateX(arg, flag)
    }

    /**
     * Sets inputed coordinate "x" of current Person element.
     *
     * @return Float
     */
    fun coordinateY (arg: String?, flag: String): Float {
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
                return coordinateY(arg, flag)
            }
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return coordinateY(arg, flag)
    }

    /**
     * Sets inputed height of current Person element.
     *
     * @return Int
     */
    fun height (arg: String?, flag: String): Int {
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
                return height(arg, flag)
            }
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return height(arg, flag)
    }

    /**
     * Sets inputed weight of current Person element.
     *
     * @return Long
     */
    fun weight (arg: String?, flag: String): Long {
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
                return weight(arg, flag)
            }
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return weight(arg, flag)
    }

    /**
     * Sets inputed color of hair of current Person element.
     *
     * @return Color
     */
    fun hairColor (arg: String?, flag: String): Color {
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
        return hairColor(arg, flag)
    }

    /**
     * Sets inputed nationality of current Person element.
     *
     * @return Country
     */
    fun nationality (arg: String?, flag: String): Country {

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
        return nationality(arg, flag)
    }

    /**
     * Sets inputed location "x" of current Person element.
     *
     * @return Int
     */
    fun locationX (arg: String?, flag: String): Int {
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
        return locationX(arg, flag)
    }

    /**
     * Sets inputed location "y" of current Person element.
     *
     * @return Long
     */
    fun locationY (arg: String?, flag: String): Long? {
        val locationY: String = if (flag == "main") {
            writeToConsole.writelnInConsole(message.getMessage("enter_locationY"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }
        try {
            return locationY.toLong()
        } catch (e: NumberFormatException) {
            writeToConsole.writelnInConsole(message.getMessage("NumberFormatException"))
        }
        return locationY(arg, flag)
    }

    /**
     * Sets inputed location "z" of current Person element.
     *
     * @return Int
     */
    fun locationZ (arg: String?, flag: String): Int {
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
        return locationZ(arg, flag)
    }
}
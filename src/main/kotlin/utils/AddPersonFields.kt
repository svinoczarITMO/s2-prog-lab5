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
            writeToConsole.linesInConsole(message.getMessage("enter_name"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }

        try {
            if (name.isBlank()) throw ElementAmountException()
            return name
        } catch (e: ElementAmountException) {
            writeToConsole.linesInConsole("Строка не может быть пустой! Введите имя ещё раз.")
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
            writeToConsole.linesInConsole(message.getMessage("enter_coordinateX"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }
        try {
            if (coordinateX.toFloat() <= 214) {
                return coordinateX.toFloat()
            } else {
                writeToConsole.linesInConsole("Координата \"x\" должна быть не больше 214!")
                if (flag == "main") {
                    return coordinateX(arg, flag)
                } else {return coordinateX as Float}
            }
        } catch (e: NumberFormatException) {
            writeToConsole.linesInConsole(message.getMessage("NumberFormatException"))
        }
        if (flag == "main") {
            return coordinateX(arg, flag)
        } else {return coordinateX as Float}
    }

    /**
     * Sets inputed coordinate "x" of current Person element.
     *
     * @return Float
     */
    fun coordinateY (arg: String?, flag: String): Float {
        val coordinateY: String = if (flag == "main") {
            writeToConsole.linesInConsole(message.getMessage("enter_coordinateY"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }
        try {
            if (coordinateY.toFloat() <= 794) {
                return coordinateY.toFloat()
            } else {
                writeToConsole.linesInConsole("Координата \"y\" должна быть не больше 794!")
                if (flag == "main") {
                    return coordinateX(arg, flag)
                } else {return coordinateY as Float}
            }
        } catch (e: NumberFormatException) {
            writeToConsole.linesInConsole(message.getMessage("NumberFormatException"))
        }
        if (flag == "main") {
            return coordinateX(arg, flag)
        } else {return coordinateY as Float}
    }

    /**
     * Sets inputed height of current Person element.
     *
     * @return Int
     */
    fun height (arg: String?, flag: String): Int {
        val height: String = if (flag == "main") {
            writeToConsole.linesInConsole(message.getMessage("enter_height"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }
        try {
            if (height.toInt() > 0) {
                return height.toInt()
            } else {
                writeToConsole.linesInConsole("Рост должен быть больше нуля!")
                if (flag == "main") {
                    return height(arg, flag)
                } else {return height as Int}
            }
        } catch (e: NumberFormatException) {
            writeToConsole.linesInConsole(message.getMessage("NumberFormatException"))
        }
        if (flag == "main") {
            return height(arg, flag)
        } else {return height as Int}
    }

    /**
     * Sets inputed weight of current Person element.
     *
     * @return Long
     */
    fun weight (arg: String?, flag: String): Long {
        val weight: String = if (flag == "main") {
            writeToConsole.linesInConsole(message.getMessage("enter_weight"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }
        try {
            if (weight.toLong() > 0) {
                return weight.toLong()
            } else {
                writeToConsole.linesInConsole("Вес должен быть больше нуля!")
                if (flag == "main") {
                    return weight(arg, flag)
                } else {return weight as Long}
            }
        } catch (e: NumberFormatException) {
            writeToConsole.linesInConsole(message.getMessage("NumberFormatException"))
        }
        if (flag == "main") {
            return weight(arg, flag)
        } else {return weight as Long}
    }

    /**
     * Sets inputed color of hair of current Person element.
     *
     * @return Color
     */
    fun hairColor (arg: String?, flag: String): Color {
        val hairColor: String = if (flag == "main") {
            writeToConsole.linesInConsole(message.getMessage("enter_hairColor"))
            for (value in 0 until Color.values().size) {
                writeToConsole.inConsole("${Color.values()[value]}")
                if (value < Color.values().size-1) {
                    writeToConsole.inConsole(", ")
                }
            }
            writeToConsole.linesInConsole("")
            readerManager.readFromConsole().uppercase()
        } else {
            arg?.uppercase() as String
        }
        try {
            return Color.valueOf(hairColor)
        } catch (e: IllegalArgumentException) {
            writeToConsole.linesInConsole(message.getMessage("IllegalColor"))
        }
        if (flag == "main") {
            return hairColor(arg, flag)
        } else {return hairColor as Color}
    }

    /**
     * Sets inputed nationality of current Person element.
     *
     * @return Country
     */
    fun nationality (arg: String?, flag: String): Country {

        writeToConsole.linesInConsole("")
        val nationality: String = if (flag == "main") {
            writeToConsole.linesInConsole(message.getMessage("enter_nationality"))
            for (value in 0 until Country.values().size) {
                writeToConsole.inConsole("${Country.values()[value]}")
                if (value < Country.values().size-1) {
                    writeToConsole.inConsole(",")
                }
            }
            writeToConsole.linesInConsole("")
            readerManager.readFromConsole().uppercase()
        } else {
            arg?.uppercase() as String
        }
        try {
            return Country.valueOf(nationality)
        } catch (e: IllegalArgumentException) {
            writeToConsole.linesInConsole(message.getMessage("IllegalCountry"))
        }
        if (flag == "main") {
            return nationality(arg, flag)
        } else {return nationality as Country}
    }

    /**
     * Sets inputed location "x" of current Person element.
     *
     * @return Int
     */
    fun locationX (arg: String?, flag: String): Int {
        val locationX: String = if (flag == "main") {
            writeToConsole.linesInConsole(message.getMessage("enter_locationX"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }
        try {
            return locationX.toInt()
        } catch (e: NumberFormatException) {
            writeToConsole.linesInConsole(message.getMessage("NumberFormatException"))
        }
        if (flag == "main") {
            return locationX(arg, flag)
        } else {return locationX as Int}
    }

    /**
     * Sets inputed location "y" of current Person element.
     *
     * @return Long
     */
    fun locationY (arg: String?, flag: String): Long? {
        val locationY: String = if (flag == "main") {
            writeToConsole.linesInConsole(message.getMessage("enter_locationY"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }
        try {
            return locationY.toLong()
        } catch (e: NumberFormatException) {
            writeToConsole.linesInConsole(message.getMessage("NumberFormatException"))
        }
        if (flag == "main") {
            return locationY(arg, flag)
        } else {return locationY as Long}
    }

    /**
     * Sets inputed location "z" of current Person element.
     *
     * @return Int
     */
    fun locationZ (arg: String?, flag: String): Int {
        val locationZ: String = if (flag == "main") {
            writeToConsole.linesInConsole(message.getMessage("enter_locationZ"))
            readerManager.readFromConsole()
        } else {
            arg as String
        }
        try {
            return locationZ.toInt()
        } catch (e: NumberFormatException) {
            writeToConsole.linesInConsole(message.getMessage("NumberFormatException"))
        }
        if (flag == "main") {
            return locationZ(arg, flag)
        } else {return locationZ as Int}
    }
}
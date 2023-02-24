package utils

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
            name.isNotBlank()
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
            coordinateX.isNotBlank(); throw ElementAmountException()
            coordinateX.toFloat(); throw java.lang.NumberFormatException()
            return coordinateX.toFloat()
        } catch (e: ElementAmountException) {
            writeToConsole.writelnToConsole("Строка не может быть пустой! Введите координату \"x\" ещё раз.")
        } catch (e: NumberFormatException) {
            writeToConsole.writelnToConsole("Введенное значение должно быть числом! Попробуйте ещё раз.")
        }
        return coordinateX()
    }

    fun coordinateY (): Float {
        writeToConsole.writelnToConsole(message.getMessage("enter_coordinateY"))
        val coordinateY = readerManager.readFromConsole()
        try {
            coordinateY.isNotBlank()
            coordinateY.toFloat()
            return coordinateY.toFloat()
        } catch (e: ElementAmountException) {
            writeToConsole.writelnToConsole("Строка не может быть пустой! Введите координату \"y\" ещё раз.")
        } catch (e: NumberFormatException) {
            writeToConsole.writelnToConsole("Введенное значение должно быть числом! Попробуйте ещё раз.")
        }
        return coordinateY()
    }
}
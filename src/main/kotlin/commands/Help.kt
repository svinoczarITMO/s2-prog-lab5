package commands

import utils.PrinterManager

class Help: Command {

    val writeToConsole: PrinterManager = PrinterManager()

    override fun execute(argument: String) {
            writeToConsole.writelnToConsole(
                    "=========================================================================================================================================\n" +
                    "help - выводит справку по доступным командам\n" +
                    "info - выводит  в стандартный поток вывода информацию о коллекции " +
                    "(тип, дата инициализации, количество элементов и т.д.)\n" +
                    "show - выводит в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                    "add - добавляет новый элемент в коллекцию\n" +
                    "update --id - обновляет значение элемента коллекции, id которого равен заданному\n" +
                    "remove_by_id --id - удаляет элемент из коллекции по его id\n" +
                    "clear - очищает коллекцию\n" +
                    "save - сохраняет коллекцию в файл\n" +
                    "execute_script --file_name - считывает и исполняет скрипт из указанного файла\n" +
                    "exit - завершает программу\n" +
                    "remove_first - удаляет первый элемент из коллекции\n" +
                    "reorder - сортирует коллекцию в порядке, обратном нынешнему\n" +
                    "history - выводит последние 7 команд (без их аргумента)\n" +
                    "min_by_weight - выводит любой объект из коллекции, значение поля weight которого является минимальным\n" +
                    "group_counting_by_nationality - группирует элементы коллекции по значению поля nationality, " +
                    "выводит количество элементов в каждой группе\n" +
                    "count_by_hair_color --hairColor - выводит количество элементов, значение поля hairColor которых равно заданному\n" +
                    "=========================================================================================================================================")
    }
}
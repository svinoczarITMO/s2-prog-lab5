import kotlin.system.exitProcess

class CommandController {
    companion object {
        fun help () {}
        fun info () {}
        fun show () {}
        fun insert (key: String) {
            print("Введите значение элемента: ")
            var element = readln()
        }
        fun update (id: Int) {
            print("Введите значение элемента: ")
            var element = readln()
        }
        fun removeKey(key: String) {}
        fun clear () {}
        fun save () {}
        fun executeScript(fileName: String) {}
        fun exit () {
            exitProcess(0)
        }
        fun removeGreater (element: String) {}
        fun replaceIfLower (key: String) {}
        fun removeGreaterKey (key: String) {}
        fun countGreaterThanDescription (description: String) {}
        fun filterLessThanGenre (name: String) {
            var genre = MusicGenre.valueOf(name)
        }
        fun printFieldDescendingNumberOfParticipants () {}

    }
}
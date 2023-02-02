class CommandController {
    companion object {
        fun help() {}
        fun info() {}
        fun show() {}
        fun insert(key: String) {
            print("Введите значение элемента: ")
            var element = readln()
        }
        fun update(id: Int) {
            print("Введите значение элемента: ")
            var element = readln()
        }
        fun removeKey(element: String) {}
        fun clear() {}
        fun save() {}
        fun executeScript(fileName: String) {}
    }
}
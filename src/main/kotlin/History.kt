import java.util.LinkedList
import java.util.Queue

class History {
    companion object {
        private var commandBuffer: LinkedList<String> = LinkedList<String>()
        fun writeInBuffer(command: String) {
            if (commandBuffer.size == 7) {
                commandBuffer.pop()
                commandBuffer.add(command)
            } else {
                commandBuffer.add(command)
            }
        }
        fun printHistory () {
            println("Последние 7 комманд: ")
            for (command in commandBuffer) {
                println(command)
            }
            println()
        }
    }
}
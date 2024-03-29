package commands

import org.jetbrains.kotlin.konan.file.File

/**
 * Executes the script according to the file path entered.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class ExecuteScript: Command() {
    private var scriptFile = File("")

    override fun getName(): String {
        return "execute_script"
    }

    override fun getDescription(): String {
        return getName() + " --file_name - считывает и исполняет скрипт из указанного файла\n"
    }

    override fun execute(args: Map<String, Any?>): String? {
        var result: String? = ""
        // глубина рекурсии
        val maxDepth = 8
        val depth: Int by args
        var actDepth = depth
        val flag = ::execute.name
        val path: String by args
        var arguments: ArrayList<Any?> = arrayListOf()
        if (File(path).exists) {
            scriptFile = File(path)
            validator.explorer(path)
        } else {
            result = message.getMessage("NoSuchFile")
            return result
        }
        try {
            if (actDepth <= maxDepth) {
                val strings = scriptFile.readStrings()
                write.linesInConsole(message.getMessage("script_start"))
                for (string in strings) {
                    val newArgs = string.split(" ").toMutableList()
                    val commandName = newArgs[0]
                    if (commandName == "execute_script") {
                        actDepth += 1
                        newArgs.add(flag)
                        newArgs.add(path)
                        newArgs.add(actDepth.toString())
                        validator.validate(newArgs.toTypedArray())
                    } else {
                        newArgs.add(flag)
                        newArgs.add(path)
                        validator.validate(newArgs.toTypedArray())
                    }
                }
            } else {
                write.linesInConsole(message.getMessage("recurision"))
            }
        } catch (e: NoSuchFileException) {
            result = (message.getMessage("NoSuchFile"))
            return result
        }
        actDepth -= 1
        if (actDepth == 0) {
            result = (message.getMessage("script_end"))
        }
        return result
    }
}
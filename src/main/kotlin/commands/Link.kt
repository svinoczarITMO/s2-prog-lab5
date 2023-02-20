package commands

class Link {
    val executeScript = ExecuteScript()

    fun start (string: String) {
        executeScript.execute(string)
    }
}
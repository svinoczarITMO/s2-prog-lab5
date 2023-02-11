package commands

class Info {
    //TODO: блин, а че делать-то ёлки-палки???
    fun info () {
        println(
            type.toString().split(".")[2] + ", "
                    + "Размер: " + vector.size + ", "
                    + when { accessability.toString() == "false, " -> "close"
                else -> "open, " } )
    }
}

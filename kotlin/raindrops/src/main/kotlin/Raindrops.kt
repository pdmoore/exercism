object Raindrops {

    private val numToSound = mapOf(
        3 to "Pling",
        5 to "Plang",
        7 to "Plong"
    )

    fun convert(n: Int): String {
        var result = ""

        numToSound.keys
            .asSequence()
            .filter { n.mod(it) == 0 }
            .forEach { result = result.plus(numToSound[it]) }

        if (result.isEmpty()) {
            result = n.toString()
        }
        return result
    }
}

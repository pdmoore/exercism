object Raindrops {

    fun convert(n: Int): String {
        var result = ""

        val numToSound = mapOf(3 to "Pling",
            5 to "Plang",
            7 to "Plong")

        for (key in numToSound.keys) {
            if (n.mod(key) == 0) {
                result = result.plus(numToSound[key])
            }
        }

        if (result.isEmpty()) {
            result = n.toString()
        }
        return result
    }
}

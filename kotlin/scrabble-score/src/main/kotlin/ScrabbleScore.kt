object ScrabbleScore {
    val letterToPointValue = mapOf(
            "AEIOULNRST" to 1,
            "DG"    to 2,
            "BCMP"  to 3,
            "FHVWY" to 4,
            "K"     to 5,
            "JX"    to 8,
            "QZ"    to 10
    )

    fun scoreLetter(c: Char): Int {
        val upperCasedCharacter = c.uppercase()

        for (key in letterToPointValue.keys) {
            if (key.contains(upperCasedCharacter)) {
                return letterToPointValue[key] ?: 0
            }
        }

        return 0;
    }

    fun scoreWord(word: String): Int {
        return  word.map { c -> scoreLetter(c) }.sum();
    }
}

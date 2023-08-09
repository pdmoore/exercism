object ScrabbleScore {
    const val onePointers = "AEIOULNRST"
    const val twoPointers = "DG"
    const val threePointers = "BCMP"
    const val fourPointers = "FHVWY"
    const val fivePointers = "K"
    const val eightPointers = "JX"
    const val tenPointers = "QZ"
    val scores = mapOf(
        onePointers to 1,
        twoPointers to 2,
        threePointers to 3,
        fourPointers to 4,
        fivePointers to 5,
        eightPointers to 8,
        tenPointers to 10
    )

    fun scoreLetter(c: Char): Int {
        val upperCasedCharacter = c.uppercase()

        for (key in scores.keys) {
            if (key.contains(upperCasedCharacter)) {
                return scores.get(key) ?: 0
            }
        }

        return 0;
    }

    fun scoreWord(word: String): Int {
        var sum = 0;
        for (character in word.iterator()) {
            sum += scoreLetter(character)
        }
        return sum;
    }
}

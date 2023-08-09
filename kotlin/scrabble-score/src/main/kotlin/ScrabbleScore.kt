object ScrabbleScore {

    fun scoreLetter(c: Char): Int {
        val onePointers = "AEIOULNRST"
        val twoPointers = "DG"
        val threePointers = "BCMP"
        val fourPointers = "FHVWY"
        val fivePointers = "K"
        val eightPointers = "JX"
        val tenPointers = "QZ"
        val scores = mapOf(onePointers to 1,
                           twoPointers to 2,
                           threePointers to 3,
                           fourPointers to 4,
                           fivePointers to 5,
                           eightPointers to 8,
                           tenPointers to 10)
        val upperCasedCharacter = c.uppercase()

        for (key in scores.keys) {
            if (key.contains(upperCasedCharacter)) {
                // TODO fix this to handle null better
                val points = scores.get(key)
                if (points != null) return points
            }
        }

        return 0;
    }

    fun scoreWord(word: String): Int {
        var sum = 0;
        for (character in word.iterator()) {
            sum += scoreLetter(character);
        }
        return sum;
    }
}

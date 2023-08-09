object ScrabbleScore {

    fun scoreLetter(c: Char): Int {
        val onePointers = "AEIOULNRST"
        val twoPointers = "DG"
        val scores = mapOf(onePointers to 1,
                           twoPointers to 2)
        val threePointLetters = listOf<String>("B", "C", "M", "P");
        val fourPointLetters = listOf<String>("F", "H", "V", "W", "Y");
        val fivePointLetters = listOf<String>("K");
        val eightPointLetters = listOf<String>("J", "X");
        val tenPointLetters = listOf<String>("Q", "Z");
        val upperCasedCharacter = c.uppercase()

        for (key in scores.keys) {
            if (key.contains(upperCasedCharacter)) {
                // TODO fix this to handle null better
                val points = scores.get(key)
                if (points != null) return points
            }
        }


        if (onePointers.contains(upperCasedCharacter)) {
            return 1
        }
        if (twoPointers.contains(upperCasedCharacter)) {
            return 2
        }
        if (threePointLetters.contains(upperCasedCharacter)) {
            return 3
        }
        if (fourPointLetters.contains(upperCasedCharacter)) {
            return 4
        }
        if (fivePointLetters.contains(upperCasedCharacter)) {
            return 5
        }
        if (eightPointLetters.contains(upperCasedCharacter)) {
            return 8
        }
        if (tenPointLetters.contains(upperCasedCharacter)) {
            return 10
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

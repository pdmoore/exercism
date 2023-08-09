object ScrabbleScore {

    fun scoreLetter(c: Char): Int {
        val onePointLetters = listOf<String>("A", "E", "I", "O", "U", "L", "N", "R", "S", "T");
        val twoPointLetters = listOf<String>("D", "G");
        val threePointLetters = listOf<String>("B", "C", "M", "P");
        val fourPointLetters = listOf<String>("F", "H", "V", "W", "Y");
        val fivePointLetters = listOf<String>("K");
        val eightPointLetters = listOf<String>("J", "X");
        val tenPointLetters = listOf<String>("Q", "Z");
        if (onePointLetters.contains(c.uppercase())) {
            return 1
        }
        if (twoPointLetters.contains(c.uppercase())) {
            return 2
        }
        if (threePointLetters.contains(c.uppercase())) {
            return 3
        }
        if (fourPointLetters.contains(c.uppercase())) {
            return 4
        }
        if (fivePointLetters.contains(c.uppercase())) {
            return 5
        }
        if (eightPointLetters.contains(c.uppercase())) {
            return 8
        }
        if (tenPointLetters.contains(c.uppercase())) {
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

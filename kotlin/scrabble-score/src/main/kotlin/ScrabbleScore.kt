object ScrabbleScore {

    fun scoreLetter(c: Char): Int {
        val onePointLetters = listOf<String>("a", "o");
        if (onePointLetters.contains(c.lowercase())) {
            return 1
        }
        if (c.lowercase().equals("z")) {
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

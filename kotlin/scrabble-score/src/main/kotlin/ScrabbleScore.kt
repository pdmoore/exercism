object ScrabbleScore {
    private fun scoreLetter(c: Char): Int =
            when (c.uppercase()) {
                in "DG" -> 2
                in "BCMP" -> 3
                in "FHVWY" -> 4
                in "K" -> 5
                in "JX" -> 8
                in "QZ" -> 10
                else -> 1   // "AEIOULNRST"
            }

    fun scoreWord(word: String): Int =
            word.sumOf(::scoreLetter)
}

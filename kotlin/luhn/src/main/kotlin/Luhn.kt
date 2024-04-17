object Luhn {

    fun isValid(candidate: String) =
        candidate.filterNot { it.isWhitespace() }
            .apply {
                if (length <= 1) return false
                if (any { !it.isDigit() }) return false
            }
            .reversed()
            .map(Character::getNumericValue)
            .mapIndexed { i, digit ->
            if (i % 2 == 0) {
                digit
            } else {
                val doubled = digit * 2
                if (doubled > 9) doubled - 9 else doubled
            }
        }.sum() % 10 == 0
}
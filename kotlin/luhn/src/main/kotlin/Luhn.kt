object Luhn {

    fun isValid(candidate: String): Boolean {
        val reversedOnlyDigits = candidate.filterNot { it.isWhitespace() }
            .apply {
                if (length <= 1) return false
                if (any { !it.isDigit() }) return false
            }.reversed()

        val sum = reversedOnlyDigits.map(Character::getNumericValue)
            .mapIndexed { i, digit ->
            if (i % 2 == 0) {
                digit
            } else {
                val doubled = digit * 2
                if (doubled > 9) doubled - 9 else doubled
            }
        }.sum()

        return sum % 10 == 0
    }
}

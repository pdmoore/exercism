object Luhn {

    fun isValid(candidate: String): Boolean {
        val reversedOnlyDigits = candidate.filterNot { it.isWhitespace() }
            .apply {
                if (length <= 1) return false
                if (any { !it.isDigit() }) return false
            }.reversed()

        var doubleThis = false
        var sum = 0
        reversedOnlyDigits.forEach { char ->
            if (doubleThis) {
                var digit = char.toString().toInt() * 2
                if (digit > 9) digit -= 9
                sum += digit
            } else {
                sum += char.toString().toInt()
            }
            doubleThis = !doubleThis
        }

        return sum % 10 == 0
    }
}

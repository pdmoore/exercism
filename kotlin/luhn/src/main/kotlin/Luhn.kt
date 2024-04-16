object Luhn {

    fun isValid(candidate: String): Boolean {
        if (!candidate.matches("[0-9 ]+".toRegex())) return false

        val reversedDigits = candidate.filter { it.isDigit() }.reversed()

        if (reversedDigits.length <= 1) {
            return false
        }

        var doubleThis = false
        var sum = 0
        for (char in reversedDigits) {
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

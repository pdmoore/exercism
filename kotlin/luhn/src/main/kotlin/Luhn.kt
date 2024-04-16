object Luhn {

    fun isValid(candidate: String): Boolean {
        var onlyDigits = candidate.filter { it.isDigit() }

        if (onlyDigits.length <= 1) {
            return false
        }

        var reversed = onlyDigits.reversed();
        var doubleThis = false
        var sum = 0
        for (char in reversed) {
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

object Bob {
    fun hey(input: String): String {
        val trimmedInput = input.trim()
        if (trimmedInput.isEmpty()) return "Fine. Be that way!"

        val containsLetters = input.any { it.isLetter() }
        val isQuestion = trimmedInput.endsWith('?')

        if (containsLetters) {
            val isYelling = input.equals(input.uppercase())

            if (isYelling && isQuestion) return "Calm down, I know what I'm doing!"
            if (isYelling) return "Whoa, chill out!"
        }
            if (isQuestion) return "Sure."

        return "Whatever."
    }
}

object Bob {
    fun hey(input: String): String {
        val containsLetters = input.any { it.isLetter() }

            val isQuestion = input.endsWith('?')
        if (containsLetters) {
            val isYelling = input.equals(input.uppercase())

            if (isYelling && isQuestion) return "Calm down, I know what I'm doing!"
            if (isYelling) return "Whoa, chill out!"
        }
            if (isQuestion) return "Sure."

        return "Whatever."
    }
}

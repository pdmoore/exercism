object Bob {
    fun hey(input: String): String {

        if (input.isSilence()) return "Fine. Be that way!"


        val trimmedInput = input.trim()

        val containsLetters = trimmedInput.any { it.isLetter() }
        val isQuestion = trimmedInput.endsWith('?')

        if (containsLetters) {
            val isYelling = trimmedInput == trimmedInput.uppercase()

            if (isYelling && isQuestion) return "Calm down, I know what I'm doing!"
            if (isYelling) return "Whoa, chill out!"
        }
        if (isQuestion) return "Sure."

        return "Whatever."
    }
}

private fun String.isSilence(): Boolean = this.trim().isEmpty()

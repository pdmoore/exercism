object Bob {
    fun hey(input: String): String {

        if (input.isSilence()) return "Fine. Be that way!"

        val containsLetters = input.trim().any { it.isLetter() }

        if (containsLetters) {
            val isYelling = input.isYelling()

            if (isYelling && input.isQuestion()) return "Calm down, I know what I'm doing!"
            if (isYelling) return "Whoa, chill out!"
        }
        if (input.isQuestion()) return "Sure."

        return "Whatever."
    }
}

private fun String.isQuestion(): Boolean = this.trim().endsWith('?')

private fun String.isYelling() = this.trim() == this.trim().uppercase()

private fun String.isSilence(): Boolean = this.trim().isEmpty()

object Bob {
    fun hey(input: String): String {

        if (input.isSilence()) return "Fine. Be that way!"

            val isYelling = input.isYelling()

            if (isYelling && input.isQuestion()) return "Calm down, I know what I'm doing!"
            if (isYelling) return "Whoa, chill out!"

        if (input.isQuestion()) return "Sure."

        return "Whatever."
    }
}

private fun String.isQuestion(): Boolean = !this.isSilence() && this.isNotEmpty() && this.trim().last() == '?'
private fun String.isYelling() = this.stripLastChar().any { it.isLetter() } && this.stripLastChar().filter { it.isLetter() }.all { it.isUpperCase() }

private val PUNCTUATION_REGEX = "[!\"#\$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]".toRegex();
private fun String.stripLastChar(): String = this.slice(0..this.length - 2)
private fun String.isPunctuations(): Boolean = PUNCTUATION_REGEX.containsMatchIn( this.stripLastChar().filter { !it.isWhitespace() } )
private fun String.isSilence(): Boolean = this.none { it.isLetterOrDigit() } && !this.isPunctuations()
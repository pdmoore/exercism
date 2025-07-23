object Bob {
    fun hey(message: String) = message.trim().run {
        if (isEmpty()) "Fine. Be that way!"
        else when (endsWith("?") to isYelled()) {
            true to true -> "Calm down, I know what I'm doing!"
            true to false -> "Sure."
            false to true -> "Whoa, chill out!"
            else -> "Whatever."
        }
    }
    private fun String.isYelled() =
        none(Char::isLowerCase) && any(Char::isLetter)
}
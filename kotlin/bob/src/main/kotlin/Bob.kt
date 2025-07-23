object Bob {
    fun hey(input: String): String {
        val containsLetters = input.any { it.isLetter() }

        if (containsLetters) {
            val isQuestion = input.endsWith('?')
            val isYelling = input.equals(input.uppercase())

            if (isYelling && isQuestion) return "Calm down, I know what I'm doing!"
            if (isQuestion) return "Sure."
            if (isYelling) return "Whoa, chill out!"
        }


        return "Whatever."
    }
}

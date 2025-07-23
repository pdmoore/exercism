object Bob {
    fun hey(input: String): String {
        if (input.endsWith('?')) return "Sure."

        if (input.equals(input.uppercase())) return "Whoa, chill out!"

        return "Whatever."
    }
}

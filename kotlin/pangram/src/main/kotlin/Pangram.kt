object Pangram {

    fun isPangram(input: String): Boolean {
        val lower = input.lowercase();
        return ('a'..'z').all {lower.contains(it)}
    }
}

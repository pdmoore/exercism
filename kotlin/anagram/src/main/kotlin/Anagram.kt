class Anagram(source: String) {
    val source = source.lowercase();

    fun match(anagrams: Collection<String>): Set<String> {
        val result = HashSet<String>()
        anagrams.forEach {

            if (!source.equals(it.lowercase()) &&
                source.lowercase().toCharArray().sorted() == it.lowercase().toCharArray().sorted()) {
                result.add(it);
            }
        }

        return result
    }
}

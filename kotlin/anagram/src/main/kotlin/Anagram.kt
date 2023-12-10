import java.util.*
import kotlin.collections.HashSet

class Anagram(source: String) {
    val source = source.lowercase();


    fun match(anagrams: Collection<String>): Set<String> {
        val result = HashSet<String>()
        anagrams.forEach {

            if (!source.equals(it.lowercase()) &&
                it.length == source.length &&
//                source.toList().containsAll(it.lowercase().toList())) {
                source.lowercase().toCharArray().sorted() == it.lowercase().toCharArray().sorted()) {
                result.add(it);
            }
        }

        return result
    }
}

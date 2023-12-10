import java.util.*
import kotlin.collections.HashSet

class Anagram(source: String) {
//    val source = Collections.sort(source.toList());
    val source = source;


    fun match(anagrams: Collection<String>): Set<String> {
        val result = HashSet<String>()
        anagrams.forEach {

            if (it.length == source.length &&
                source.toList().containsAll(it.toList())) {
                result.add(it);
            }
        }

        return result
    }
}

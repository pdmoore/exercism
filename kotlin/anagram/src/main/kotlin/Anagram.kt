import java.util.*
import kotlin.collections.HashSet

class Anagram(source: String) {
//    val source = Collections.sort(source.toList());
    val source = source;


    fun match(anagrams: Collection<String>): Set<String> {
        // TODO("Implement the function to complete the task")
//        if (source.equals(anagrams.iterator().next())) Collections.emptyList<String>()
        val result = HashSet<String>()
        anagrams.forEach {

            if (source.toList().containsAll(it.toList())) {
                result.add(it);
            }
        }

        return result
    }
}

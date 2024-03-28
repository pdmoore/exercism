import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class ParallelLetterFrequency {
    Map<Character, Integer> charCount = new ConcurrentHashMap<>();

    ParallelLetterFrequency(String[] texts) {
        List.of(texts)
                .parallelStream()
                .forEach(line -> line.replaceAll("[^\\p{L}]", "")
                        .chars()
                        .forEach(ch -> charCount.merge(Character.toLowerCase((char) ch), 1, Integer::sum)));
    }

    Map<Character, Integer> countLetters() {
        return charCount;
    }
}

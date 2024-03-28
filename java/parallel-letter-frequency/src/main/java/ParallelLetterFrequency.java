import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class ParallelLetterFrequency {
    Map<Character, Integer> charCount = new ConcurrentHashMap<>();

    ParallelLetterFrequency(String[] texts) {
        Arrays.stream(texts)
                .parallel()
                .forEach(line -> line.replaceAll("[^\\p{L}]", "")
                        .chars()
                        .forEach(ch -> charCount.merge(Character.toLowerCase((char) ch), 1, Integer::sum)));
    }

    Map<Character, Integer> countLetters() {
        return charCount;
    }
}

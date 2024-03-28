import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ParallelLetterFrequency {
    Map<Character, Integer> charCount = new HashMap<>();


    ParallelLetterFrequency(String[] texts) {

        Arrays.stream(texts).sequential().forEach(ch -> charCount.put(ch.charAt(0), 1));

    }

    Map<Character, Integer> countLetters() {
        return charCount;
    }

}

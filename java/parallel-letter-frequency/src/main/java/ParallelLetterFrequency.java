import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ParallelLetterFrequency {
    Map<Character, Integer> charCount = new HashMap<>();


    ParallelLetterFrequency(String[] texts) {

        // texts is an array of lines
        for (int i = 0; i < texts.length; i++) {
            texts[i].chars().forEach(ch -> charCount.merge((char) ch, 1, Integer::sum));
        }


    }

    Map<Character, Integer> countLetters() {
        return charCount;
    }

}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ParallelLetterFrequency {
    Map<Character, Integer> charCount = new HashMap<>();


    ParallelLetterFrequency(String[] texts) {

        Arrays.stream(texts).
                sequential().
                forEach(line -> line.replaceAll("[^a-zA-Z]", "").chars().
                        forEach(ch -> charCount.merge(Character.toLowerCase((char) ch), 1, Integer::sum)));


        // texts is an array of lines
//        for (int i = 0; i < texts.length; i++) {
//            // strip out white space
//            texts[i].chars().forEach(ch -> charCount.merge(Character.toLowerCase((char) ch), 1, Integer::sum));
//
//        }


    }

    Map<Character, Integer> countLetters() {
        return charCount;
    }

}

import java.util.Arrays;
import java.util.List;

public class PigLatinTranslator {

    private static final List<Character> VOWELS = Arrays.asList('a', 'e', 'i', 'o','u');

    public String translate(String word) {

        if (startsWithVowel(word)) {

            return word + "ay";

        }

        return null;
    }

    private boolean startsWithVowel(String word) {
        return VOWELS.contains(word.charAt(0));
    }
}
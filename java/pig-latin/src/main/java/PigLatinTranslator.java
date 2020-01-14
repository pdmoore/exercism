import java.util.Arrays;
import java.util.List;

public class PigLatinTranslator {

    private static final List<Character> VOWELS = Arrays.asList('a', 'e', 'i', 'o','u');

    public String translate(String word) {

        if (startsWithVowel(word)) {

            return word + "ay";
        }

        int firstVowel = firstVowelIn(word);


        String pigLatin = word.substring(firstVowel) + word.substring(0, firstVowel) + "ay";
        return pigLatin;
    }

    private int firstVowelIn(String word) {
        int i = 0;
        while (!VOWELS.contains(word.charAt(i))) {
            ++i;
        }

        return i;
    }

    private boolean startsWithVowel(String word) {
        return VOWELS.contains(word.charAt(0));
    }
}
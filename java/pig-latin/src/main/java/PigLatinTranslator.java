import java.util.Arrays;
import java.util.List;

public class PigLatinTranslator {

    //TODO - handle
    // y cases
    // xr
    // phrase of more than one word


    private static final List<Character> VOWELS = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public String translate(String word) {

        if (startsWithVowel(word)) {
            return word + "ay";
        } else if (startsWithYt(word)) {
            return word + "ay";
        }

        if (!word.contains("qu")) {

            int firstVowel = firstVowelIn(word);

            String pigLatin = word.substring(firstVowel) + word.substring(0, firstVowel) + "ay";
            return pigLatin;
        } else {

            int firstVowel = firstVowelIn(word);
            ++firstVowel;
            String pigLatin = word.substring(firstVowel) + word.substring(0, firstVowel) + "ay";
            return pigLatin;
        }

    }

    private boolean startsWithYt(String word) {
        return word.substring(0, 2).equals("yt");
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
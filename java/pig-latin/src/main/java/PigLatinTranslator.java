import java.util.Arrays;
import java.util.List;

public class PigLatinTranslator {

    // TODO - refactor
    // suffix "ay"
    // add space between words in phrase?
    // compose pigLatinFor for readability

    private static final List<Character> VOWELS = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public String translate(String phrase) {

        String[] words = phrase.split(" ");

        StringBuilder translation = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            translation.append(pigLatinFor(words[i]));
            if (i < words.length - 1) {
                translation.append(" ");
            }
        }

        return translation.toString();
    }

    private String pigLatinFor(String word) {
        if (startsWithVowel(word) ||
                startsWithSpecialCharacters(word, "yt") ||
                startsWithSpecialCharacters(word, "xr")) {
            return word + "ay";
        }

        if (word.contains("qu")) {

            int firstVowel = firstVowelIn(word);

            ++firstVowel;
            String pigLatin = word.substring(firstVowel) + word.substring(0, firstVowel) + "ay";
            return pigLatin;

        }

        int firstVowel = firstVowelIn(word);
        if (firstVowel != 0) {

            String pigLatin = word.substring(firstVowel) + word.substring(0, firstVowel) + "ay";
            return pigLatin;
        }

        int firstY = firstYIn(word);
        String pigLatin = word.substring(firstY) + word.substring(0, firstY) + "ay";
        return pigLatin;
    }

    private boolean startsWithSpecialCharacters(String word, String specialStart) {
        return word.substring(0, 2).equals(specialStart);
    }

    private int firstVowelIn(String word) {
        int i = 0;
        while (!VOWELS.contains(word.charAt(i))) {
            ++i;
            if (i >= word.length()) {
                return 0;
            }
        }

        return i;
    }

    private int firstYIn(String word) {
        int i = 0;
        while (word.charAt(i) != 'y') {
            ++i;
            if (i >= word.length()) {
                return 0;
            }
        }

        return i;
    }

    private boolean startsWithVowel(String word) {
        return VOWELS.contains(word.charAt(0));
    }
}
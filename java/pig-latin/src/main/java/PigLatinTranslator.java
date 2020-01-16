import java.util.Arrays;
import java.util.List;

public class PigLatinTranslator {

    // TODO - refactor
    // suffix "ay"
    // add space between words in phrase?
    // compose pigLatinFor for readability

    private static final List<Character> VOWELS = Arrays.asList('a', 'e', 'i', 'o', 'u');
    public static final String AY = "ay";

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
            return word + AY;
        }

        if (word.contains("qu")) {
            int characterAfterFirstVowel = indexOffirstVowelIn(word) + 1;
            return convertToPigLatinAtIndex(word, characterAfterFirstVowel);

        }

        if (wordHasAnyVowel(word)) {
            int firstVowel = indexOffirstVowelIn(word);
            return convertToPigLatinAtIndex(word, firstVowel);
        }

        int firstY = indexOfFirstYIn(word);
        return convertToPigLatinAtIndex(word, firstY);
    }

    private String convertToPigLatinAtIndex(String word, int splitWordAt) {
        String wordAfterSplit = word.substring(splitWordAt);
        String wordBeforeSplit = word.substring(0, splitWordAt);
        return wordAfterSplit + wordBeforeSplit + AY;
    }

    private boolean wordHasAnyVowel(String word) {
        int firstVowel = indexOffirstVowelIn(word);
        return firstVowel != 0;
    }

    private boolean startsWithSpecialCharacters(String word, String specialStart) {
        return word.substring(0, 2).equals(specialStart);
    }

    // TODO - duplicate logic in Vowels and Y searching logic
    private int indexOffirstVowelIn(String word) {
        int i = 0;
        while (!VOWELS.contains(word.charAt(i))) {
            ++i;
            if (i >= word.length()) {
                return 0;
            }
        }

        return i;
    }

    private int indexOfFirstYIn(String word) {
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
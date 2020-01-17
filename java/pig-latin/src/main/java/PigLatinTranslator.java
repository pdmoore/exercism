import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PigLatinTranslator {

    private static final List<Character> VOWELS = Arrays.asList('a', 'e', 'i', 'o', 'u');
    public static final String AY = "ay";

    public String translate(String phrase) {
        return String.join(" ",
                Arrays.stream(phrase.split(" ")).
                        map(s -> pigLatinFor(s)).
                        collect(Collectors.toList()));
    }

    //TODO - could have a single return statement by capturing which index to split the word at in each if
    private String pigLatinFor(String word) {
        if (startsWithVowel(word) ||
                startsWithSpecialCharacters(word, "yt") ||
                startsWithSpecialCharacters(word, "xr")) {
            return convertToPigLatinAtIndex(word, 0);
        }

        if (word.contains("qu")) {
            int characterAfterFirstVowel = indexOfFirstVowelIn(word) + 1;
            return convertToPigLatinAtIndex(word, characterAfterFirstVowel);
        }

        if (wordHasAnyVowel(word)) {
            int firstVowel = indexOfFirstVowelIn(word);
            return convertToPigLatinAtIndex(word, firstVowel);
        }

        int firstY = indexOfFirstYIn(word);
        return convertToPigLatinAtIndex(word, firstY);
    }

    private String convertToPigLatinAtIndex(String word, int splitWordAt) {
        String charactersAfterSplit = word.substring(splitWordAt);
        String charactersBeforeSplit = word.substring(0, splitWordAt);
        return charactersAfterSplit + charactersBeforeSplit + AY;
    }

    private boolean wordHasAnyVowel(String word) {
        int firstVowel = indexOfFirstVowelIn(word);
        return firstVowel != 0;
    }

    private boolean startsWithSpecialCharacters(String word, String specialStart) {
        return word.substring(0, 2).equals(specialStart);
    }

    private int indexOfFirstVowelIn(String word) {
        for (int j = 0; j < word.length(); j++) {
            if (VOWELS.contains(word.charAt(j))) {
                return j;
            }
        }

        return 0;
    }

    private int indexOfFirstYIn(String word) {
        return word.indexOf('y');
    }

    private boolean startsWithVowel(String word) {
        return VOWELS.contains(word.charAt(0));
    }
}
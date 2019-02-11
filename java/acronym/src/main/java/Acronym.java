import java.util.Arrays;
import java.util.stream.Collectors;

class Acronym {

//    private final String phrase;
//
//    Acronym(String phrase) {
//        this.phrase = phrase;
//    }
//
//    String get() {
//        return Arrays.stream(phrase.split("[-\\s]"))
//            .map(w -> Character.toString(w.charAt(0)))
//            .collect(Collectors.joining())
//            .toUpperCase();
//    }

    String phrase;
    String[] words = {};

    Acronym(String phrase) {
        String new_phrase = phrase.replace("-", " ");
        words = new_phrase.split("\\s+");
    }

    String get() {
        String acro = "";
        String first_letter;
        for (int i = 0; i < words.length; i++){
            first_letter = words[i].substring(0, 1);
            first_letter = first_letter.toUpperCase() ;
            acro = acro.concat(first_letter);
        }
        return acro;
    }
}

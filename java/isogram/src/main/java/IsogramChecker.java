import java.util.HashSet;
import java.util.Set;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        Set<Character> characterSeen = new HashSet<>();

        for (int i = 0; i < phrase.length(); i++) {
            Character thisChar = Character.toLowerCase(phrase.charAt(i));
            if (!Character.isAlphabetic(thisChar)) continue;

            if (characterSeen.contains(thisChar)) {
                return false;
            }
            characterSeen.add(thisChar);
        }

        return true;
    }
}

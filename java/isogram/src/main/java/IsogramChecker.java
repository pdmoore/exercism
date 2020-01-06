import java.util.ArrayList;
import java.util.List;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        List<Character> characterSeen = new ArrayList<>();

        for (int i = 0; i < phrase.length(); i++) {
            Character thisChar = phrase.charAt(i);
            if (characterSeen.contains(thisChar)) {
                return false;
            }
            characterSeen.add(thisChar);
        }

        return true;
    }

}

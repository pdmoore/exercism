public class RunLengthEncoding {


    public String encode(String unencoded) {
        StringBuilder encoded = new StringBuilder();

        int i = 0;
        while (i < unencoded.length()) {

            char thisChar = unencoded.charAt(i);

            if (nextCharacterIsDifferent(unencoded, i) || i == unencoded.length() - 1) {
                i = encodeSingleCharacter(unencoded, encoded, i);
            } else {
                i = encodeRepeatedCharacter(unencoded, encoded, i);
            }
        }

        return encoded.toString();
    }

    private int encodeRepeatedCharacter(String unencoded, StringBuilder encoded, int i) {
        Character thisChar = unencoded.charAt(i);
        int j = i + 1;
        while (theNextCharacterIsSame(unencoded, thisChar, j)) {
            j++;
        }
        int repeatedCharCount = j - i;
        char repeatedCharacter = unencoded.charAt(i);
        encoded.append(repeatedCharCount);
        encoded.append(repeatedCharacter);
        return j;
    }

    private int encodeSingleCharacter(String unencoded, StringBuilder encoded, int i) {
        encoded.append(unencoded.charAt(i));
        return ++i;
    }

    private boolean nextCharacterIsDifferent(String unencoded, int i) {
        Character thisChar = unencoded.charAt(i);
        Character nextChar = null;
        if (i < unencoded.length() - 1) {
            nextChar = unencoded.charAt(i + 1);
        }
        return nextChar != null && nextChar != thisChar;
    }

    private boolean theNextCharacterIsSame(String unencoded, char thisChar, int j) {
        return j < unencoded.length() && (unencoded.charAt(j) == thisChar);
    }

    public String decode(String encoded) {

        StringBuilder decoded = new StringBuilder();

        int i = 0;
        while (i < encoded.length()) {

            Character thisChar = encoded.charAt(i);
            if (!Character.isDigit(thisChar)) {
                decoded.append(encoded.charAt(i));
                ++i;
            } else {
                int repeatCount = grabCountFrom(i, encoded);
                char charToRepeat = encoded.charAt(i + String.valueOf(repeatCount).length());
                for (int j = 0; j < repeatCount; j++) {
                    decoded.append(charToRepeat);
                }

                i += String.valueOf(repeatCount).length() + 1;
            }
        }

        return decoded.toString();
    }

    private int grabCountFrom(int i, String encoded) {
        for (int j = i + 1; j <= encoded.length(); j++) {
            if (!Character.isDigit(encoded.charAt(j))) {
                String digit = encoded.substring(i, j);
                return Integer.parseInt(digit);
            }
        }

        return 1;
    }
}

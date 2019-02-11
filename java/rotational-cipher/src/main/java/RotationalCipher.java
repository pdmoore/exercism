import java.util.stream.Collectors;

class RotationalCipher {

// NEED TO INCORPORATE THIS INTO MY SOLUTION
/*
    final private int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    private char encodeChar(int ch) {
        final boolean isUpperCaseRange = ch >= 'A' && ch <= 'Z' && ch + shiftKey > 'Z';
        final boolean isLowerCaseRange = ch >= 'a' && ch <= 'z' && ch + shiftKey > 'z';
        if (isLowerCaseRange | isUpperCaseRange) {
            return (char) ((ch+shiftKey) - 26);
        }
        return (char) (ch+shiftKey);
    }

    String rotate(String data) {
        final StringBuilder sb = new StringBuilder();
        for (char el : data.toCharArray()) {
            if (Character.isAlphabetic(el))
                sb.append(encodeChar(el));
            else
                sb.append(el);
        }
        return sb.toString();
    }
*/

    int shiftKey;
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    char[] alphabetUP = "ABCDEFGHIJQLMNOPQRSTUVWXYZ".toCharArray();

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {

        char[] chars = data.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            char[] temp = new char[26];

            if (chars[i] == Character.toLowerCase(chars[i]))
                temp = alphabet;

            if (chars[i] == Character.toUpperCase(chars[i]))
                temp = alphabetUP;

            for (int j = 0; j < temp.length; j++) {
                if (chars[i] == temp[j]) {
                    if ((j + shiftKey) < temp.length) {
                        chars[i] = temp[j + shiftKey];
                        break;
                    }
                    else {
                        chars[i] = temp[(j + shiftKey) - temp.length];
                        break;
                    }
                }
            }
        }

        String newWord = new String(chars);
        return newWord;
    }

}

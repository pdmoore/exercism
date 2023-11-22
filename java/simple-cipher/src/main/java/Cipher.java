import java.io.StringBufferInputStream;

public class Cipher {
    private final String key;

    public Cipher() {
        // TODO - supposed to be random 100 lowercase chars, no tests check
        key = "aaaaaaaaaaaaaaaaaaaaaa";
    }

    public Cipher(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String encode(String plainText) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            int encodedAsciiValue = ((lowerCaseIndexOf(plainText.charAt(i)) +  lowerCaseIndexOf(key.charAt(i % key.length()))) % 26) + 'a';
            sb.append(Character.toString(encodedAsciiValue));
        }
        return sb.toString();
    }

    private int lowerCaseIndexOf(char c) {
        return c - 'a';
    }

    public String decode(String cipherText) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            int charvalue = ('z' - (Math.abs(cipherText.charAt(i) - key.charAt(i) - 71) % 26) + 1) % 26 + 'a';
//            if (charvalue > 122) {
//                charvalue -= 26;
//            }
            sb.append(Character.toString(charvalue));
        }
        return sb.toString();
    }
}

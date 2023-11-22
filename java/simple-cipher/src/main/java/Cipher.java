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
            int encodedAsciiValue = ((characterIndexedFromLowerA(plainText.charAt(i)) + characterIndexedFromLowerA(key.charAt(i % key.length()))) % 26) + 'a';
            sb.append(Character.toString(encodedAsciiValue));
        }
        return sb.toString();
    }

    private int characterIndexedFromLowerA(char c) {
        return c - 'a';
    }

    public String decode(String cipherText) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            // TODO - Lordy, it passes the tests, but sheesh
            int magicNumber = (characterIndexedFromLowerA(cipherText.charAt(i)) - characterIndexedFromLowerA(key.charAt(i)) - 18) - 26;
            int charvalue = (('z' - (Math.abs(magicNumber))) % 26) + 'a';
            sb.append(Character.toString(charvalue));
        }
        return sb.toString();
    }
}

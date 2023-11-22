import java.io.StringBufferInputStream;

public class Cipher {
    private final String key;

    public Cipher() {
        // TODO - supposed to be random 100 lowercase chars
        key = "aaaaaaaaaaaaaaaaaaaaaa";
    }

    public Cipher(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String encode(String plainText) {
        int length = plainText.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int charvalue = Math.abs(plainText.charAt(i) - key.charAt(i)) + 'a';
            sb.append(Character.toString(charvalue));
        }
        return sb.toString();
    }

    public String decode(String cipherText) {
        int length = cipherText.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int charvalue = Math.abs(cipherText.charAt(i) - key.charAt(i)) + 'a';
            sb.append(Character.toString(charvalue));
        }
        return sb.toString();
    }
}

public class Cipher {
    private final String key;

    public Cipher() {
        key = "aaaaaaaaaa";
    }

    public Cipher(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String encode(String plainText) {
        return plainText;
    }

    public String decode(String cipherText) {
        throw new UnsupportedOperationException("Please implement the Cipher.decode() method.");
    }
}

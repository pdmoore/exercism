import java.math.BigInteger;

public class DiffieHellman {

    public BigInteger privateKey(BigInteger prime) {
        return prime.subtract(BigInteger.ONE);
    }

    public BigInteger publicKey(BigInteger primeA, BigInteger primeB, BigInteger privateKey) {
        return null;
    }

    public BigInteger secret(BigInteger prime, BigInteger publicKey, BigInteger privateKey) {
        return null;
    }
}

import java.math.BigInteger;
import java.util.Random;

public class DiffieHellman {

    public BigInteger privateKey(BigInteger prime) {

        BigInteger randomNumber;
        do {
            randomNumber = new BigInteger(prime.bitLength(), new Random());
        } while (randomNumber.compareTo(prime) >= 0);

        return randomNumber;
    }

    public BigInteger publicKey(BigInteger primeA, BigInteger primeB, BigInteger privateKey) {
        return primeB.modPow(privateKey, primeA);
    }

    public BigInteger secret(BigInteger prime, BigInteger publicKey, BigInteger privateKey) {
        return publicKey.modPow(privateKey, prime);
    }
}

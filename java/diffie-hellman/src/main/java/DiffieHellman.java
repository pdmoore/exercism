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
        BigInteger answer = primeB.pow(privateKey.intValue()).mod(primeA);
        return answer;
    }

    public BigInteger secret(BigInteger prime, BigInteger publicKey, BigInteger privateKey) {
        BigInteger answer = publicKey.pow(privateKey.intValue()).mod(prime);
        return answer;
    }
}

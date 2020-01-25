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

// g
        // a -privateKey
//        A = g**a mod p
        ///sooooo... how do primeA and primeB map to g and p
        // BigInt.pow expects an int, not a BigInt (privateKey) - do I need to roll my own g**a?

        return null;
    }

    public BigInteger secret(BigInteger prime, BigInteger publicKey, BigInteger privateKey) {
        return null;
    }
}

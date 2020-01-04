import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Sieve {
    private final List primes;

    Sieve(int maxPrime) {
        if (maxPrime <= 1) {
            primes = Collections.emptyList();
        } else {
            primes = sievePrimes(maxPrime);
        }
    }

    private List<Integer> sievePrimes(int maxPrime) {
        Boolean[] isItPrime = new Boolean[maxPrime + 1];
        for (int i = 0; i < maxPrime + 1; i++) {
            isItPrime[i] = true;
        }

        List<Integer> confirmedPrimes = new ArrayList<>();
        for (int i = 2; i < isItPrime.length; i++) {
            if (isItPrime[i]) {
                confirmedPrimes.add(i);
                removeMultiplesOfThisPrime(isItPrime, i);
            }
        }

        return confirmedPrimes;
    }

    private void removeMultiplesOfThisPrime(Boolean[] isItPrime, int i) {
        for (int j = i; j < isItPrime.length; j = j + i) {
            isItPrime[j] = false;
        }
    }

    List<Integer> getPrimes() {
        return primes;
    }
}

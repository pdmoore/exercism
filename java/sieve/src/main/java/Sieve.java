import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Sieve {
    private List primes;

    Sieve(int maxPrime) {
        if (maxPrime <= 1) {
            primes = Collections.emptyList();
        } else {
            sievePrimes(maxPrime);
        }
    }

    private void sievePrimes(int maxPrime) {
        Boolean[] candidates = new Boolean[maxPrime + 1];
        for (int i = 0; i < maxPrime + 1; i++) {
            candidates[i] = true;
        }

        primes = new ArrayList<>();
        for (int i = 2; i < candidates.length; i++) {
            if (candidates[i]) primes.add(i);

            removeMultiplesOfCandidate(candidates, i);
        }
    }

    private void removeMultiplesOfCandidate(Boolean[] candidates, int i) {
        for (int j = i; j < candidates.length; j = j + i) {
            candidates[j] = false;
        }
    }

    List<Integer> getPrimes() {
        return primes;
    }
}

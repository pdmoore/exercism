import java.util.ArrayList;
import java.util.List;

class PrimeCalculator {

    int nth(int nth) {
        if (nth < 1) {
            throw new IllegalArgumentException();
        }

        List<Integer> discoveredPrimes = new ArrayList<>();
        discoveredPrimes.add(2);

        int i = 2;
        while (discoveredPrimes.size() < nth) {
            ++i;

            if (isPrime(i, discoveredPrimes)) {
                discoveredPrimes.add(i);
            }
        }

        return discoveredPrimes.get(nth - 1);
    }

    private boolean isPrime(int candidate, List<Integer> discoveredPrimes) {
        for (Integer knownPrime :
                discoveredPrimes) {
            if (candidate % knownPrime == 0) return false;
        }

        return true;
    }

}

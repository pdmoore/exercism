import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class PrimeCalculator {

    public static final int FIRST_PRIME = 2;

    int nth(int nth) {
        if (nth < 1) {
            throw new IllegalArgumentException();
        }

        List<Integer> discoveredPrimes = new ArrayList<>();

        IntStream.iterate(FIRST_PRIME, i -> i + 1).
                filter(i -> isPrime(i, discoveredPrimes)).
                limit(nth).
                forEach(i -> discoveredPrimes.add(i));

        return discoveredPrimes.get(nth - 1);
    }

    // TODO - find a way to short circuit this - as soon as an item is divisible by a candidate we know it is not prime
    // might be worth trying a performance/time test
    private boolean isPrime(int candidate, List<Integer> discoveredPrimes) {
        return discoveredPrimes.stream().filter(i -> candidate % i == 0).count() == 0;
    }

}

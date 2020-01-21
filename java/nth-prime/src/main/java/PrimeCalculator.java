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

    private boolean isPrime(int candidate, List<Integer> discoveredPrimes) {
        return discoveredPrimes.stream().filter(i -> candidate % i == 0).count() <=  0;
    }

}

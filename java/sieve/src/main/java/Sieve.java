import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Sieve {
    private final Boolean[] foo;

    Sieve(int maxPrime) {
        if (maxPrime <= 1) {
            foo = new Boolean[1];
        } else {

            // create boolean array up to maxPrime in length
            foo = new Boolean[maxPrime + 1];
            for (int i = 0; i < maxPrime + 1; i++) {
                foo[i] = true;
            }
        }
    }

    List<Integer> getPrimes() {
        // loop from 2 length
        // mark each multiple as prime
        // as looping, capture whether number was marked already or not

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < foo.length; i++) {
            if (foo[i]) primes.add(i);

            for (int j = i; j < foo.length; j = j + i) {
                foo[j] = false;
            }
        }

        return primes;
    }
}

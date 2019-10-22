import java.util.Arrays;
import java.util.List;

class SumOfMultiples {

    private final int number;
    private final int[] set;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            for (int j = 0; j < set.length; j++) {
                if (set[j] != 0) {
                    if (i % set[j] == 0) {
                        sum += i;
                        break;
                    }
                }
            }
        }

        return sum;
    }

}

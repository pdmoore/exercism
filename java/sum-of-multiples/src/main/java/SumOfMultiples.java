import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class SumOfMultiples {

    private final int number;
    private final List<Integer> ints;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        ints = Arrays.stream(set).filter(n -> n > 0).boxed().collect(Collectors.toList());
    }

    // @Todo Refactor to streaming solution, remove collecting var 'sum'
    int getSum() {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            for (int j :
                    ints) {
                if (i % j == 0) {
                    sum += i;
                    break;
                }
            }
        }

        return sum;
    }

}

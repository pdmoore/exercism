import java.util.ArrayList;
import java.util.List;

class NaturalNumber {


    private Classification classification;

    public NaturalNumber(int number) {
        validateParameter(number);

        int aliquotSum = calculateAliquotSum(number);

        if (aliquotSum == number) {
            classification = Classification.PERFECT;
        } else if (aliquotSum > number) {
            classification = Classification.ABUNDANT;
        } else {
            classification = Classification.DEFICIENT;
        }
    }

    private int calculateAliquotSum(int number) {
        List<Integer> divisors = new ArrayList<>();
        int halfNumber = number / 2;
        for (int i = 1; i <= halfNumber; i++) {
            if (number % i == 0) {
                divisors.add(i);
            }
        }

        return divisors.stream().mapToInt(Integer::intValue).sum();
    }

    private void validateParameter(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
    }

    public Classification getClassification() {
        return classification;
    }
}

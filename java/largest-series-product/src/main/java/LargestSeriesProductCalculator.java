import java.util.ArrayList;
import java.util.List;

class LargestSeriesProductCalculator {
    private final String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (numberOfDigits > inputNumber.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        int result = 0;

        for (int i = 0; i < inputNumber.length() - numberOfDigits + 1; i++) {

            List<Integer> digitsToMultiply = new ArrayList<>();
            for (int j = 0; j < numberOfDigits; j++) {
                digitsToMultiply.add(Integer.parseInt(String.valueOf(inputNumber.charAt(i+j))));
            }

            int thisResult = digitsToMultiply.stream().reduce(1, (a, b) -> a * b);

            result = Math.max(result, thisResult);
        }

        return result;
    }

}

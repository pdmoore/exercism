import java.util.ArrayList;
import java.util.List;

class LargestSeriesProductCalculator {
    private final String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        mustBeOnlyDigits(inputNumber);
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        validateArgument(numberOfDigits);

        int result = 0;

        // Start with each number, stepping one by one
        for (int i = 0; i < inputNumber.length() - numberOfDigits + 1; i++) {

            // Grab that number and the next numberOfDigits following it
            List<Integer> digitsToMultiply = new ArrayList<>();
            for (int j = 0; j < numberOfDigits; j++) {
                digitsToMultiply.add(Character.getNumericValue(inputNumber.charAt(i+j)));
            }

            int thisResult = digitsToMultiply.stream().reduce(1, (a, b) -> a * b);

            result = Math.max(result, thisResult);
        }

        return result;
    }

    private void mustBeOnlyDigits(String inputNumber) {
        for (int i = 0; i <inputNumber.length(); i++) {
            if (!Character.isDigit(inputNumber.charAt(i))) {
                throw new IllegalArgumentException("String to search may only contain digits.");
            }
        }
    }

    private void validateArgument(int numberOfDigits) {
        if (numberOfDigits > inputNumber.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
    }

}

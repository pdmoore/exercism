class LargestSeriesProductCalculator {
    private final String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        int result = 0;

        int digit1 = Integer.parseInt(String.valueOf(inputNumber.charAt(0)));
        int digit2 = Integer.parseInt(String.valueOf(inputNumber.charAt(1)));

        result = digit1 * digit2;

        return result;
    }
}

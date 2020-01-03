class LargestSeriesProductCalculator {
    private final String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        int result = 0;

        for (int i = 0; i < inputNumber.length() - numberOfDigits + 1; i++) {
            int digit1 = Integer.parseInt(String.valueOf(inputNumber.charAt(i)));
            int digit2 = Integer.parseInt(String.valueOf(inputNumber.charAt(i+1)));
            int thisResult = digit1 * digit2;

            result = Math.max(result, thisResult);
        }

        return result;
    }
}

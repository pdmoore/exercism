class AllYourBase {

    int inputBase;
    int value;

    AllYourBase(inputBase, digits) {
        if (inputBase <= 1) {
            throw new ArithmeticException("Base must be 2 or greater");
        }

        this.inputBase = inputBase;
        def sum = 0;
        for (int i = 0; i < digits.size; i++) {
            if (digits[i] < 0) {
                throw new ArithmeticException("Digit must be zero or positive");
            }
            if (digits[i] >= inputBase) {
                throw new ArithmeticException("Digit must be less than base");
            }
            sum += (inputBase**(digits.size - i - 1)) * digits[i];
        }

        this.value = sum;
    }

    def rebase(outputBase) {
        if (this.value == 0) {
            return [0];
        }

        def result = [];
        int num = this.value;
        while (num > 0) {
            int remainder = num % outputBase;
            result.add(remainder);
            num = num / outputBase;
        }

        return result.reverse();
    }
}
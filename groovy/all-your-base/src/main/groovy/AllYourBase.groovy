class AllYourBase {

    int value;

    AllYourBase(inputBase, digits) {
        if (inputBase <= 1) {
            throw new ArithmeticException("Base must be 2 or greater");
        }

        digits.eachWithIndex { int digit, int pos ->
            if (digit < 0) {
                throw new ArithmeticException("Digit must be zero or positive");
            }
            if (digit >= inputBase) {
                throw new ArithmeticException("Digit must be less than base");
            }
            this.value += (inputBase**(digits.size - pos - 1)) * digit;
        }
    }

    def rebase(outputBase) {
        if (outputBase <= 1) {
            throw new ArithmeticException("Base must be 2 or greater");
        }

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